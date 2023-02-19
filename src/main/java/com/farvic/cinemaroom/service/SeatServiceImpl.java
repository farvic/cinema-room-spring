package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Token;
import com.farvic.cinemaroom.errors.OrderException;
import com.farvic.cinemaroom.repositories.CinemaRepository;
import com.farvic.cinemaroom.repositories.OrderRepository;
import com.farvic.cinemaroom.repositories.SeatRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    final private CinemaRepository cinemaRepository;
    final private SeatRepository seatRepository;

    final private OrderRepository orderRepository;

    /**
     * Construct SeatService
     *
     * @param cinemaRepository Cinema Repository
     * @param seatRepository   Seat Repository
     * @param orderRepository  Order Repository
     */
    public SeatServiceImpl(CinemaRepository cinemaRepository, SeatRepository seatRepository,
            OrderRepository orderRepository) {
        this.cinemaRepository = cinemaRepository;
        this.seatRepository = seatRepository;
        this.orderRepository = orderRepository;

    }

    /**
     * Get all seats in the cinema room with the id 1 (only one in the project)
     * 
     * @return List of seats
     * @throws ResourceNotFoundException if the cinema is closed
     * 
     */

    @Override
    public List<Seat> getAllSeats() {
        if (!cinemaRepository.existsById(1)) {
            throw new ResourceNotFoundException("The cinema is closed");
        }
        return seatRepository.findByCinemaId(1);
    }

    /**
     * Purchase a seat and return the order which contains the the
     * seat (ticket) and an UUID token
     * 
     * @param seat Seat to purchase
     * @return Order
     * @throws OrderException if the seat is not available or the row or column
     * 
     */

    @Override
    public Order purchaseSeat(Seat seat) {

        Seat _seat = seatRepository.findByRowAndColumn(seat.getRow(), seat.getColumn())
                .orElseThrow(() -> new OrderException("The number of a row or a column is out of bounds!"));

        if (_seat.isAvailable()) {

            _seat.setIsAvailable(false);

            seatRepository.save(_seat);

            Order order = new Order(_seat);

            orderRepository.save(order);

            return order;

        } else {
            throw new OrderException("The ticket has been already purchased!");
        }
    }

    /**
     * Return a ticket by the token
     * 
     * @param token Token
     * @return Order
     * @throws OrderException if the token is wrong
     * 
     */

    @Override
    public Order refundTicket(Token token) {

        Order order = orderRepository.findByToken(token.getToken());

        if (order == null) {
            throw new OrderException("Wrong token!");
        }

        Seat seat = order.getTicket();

        seat.setIsAvailable(true);

        seatRepository.save(seat);

        Order _order = new Order(order.getToken(), order.getTicket(), true);

        order.setTicket(null);

        orderRepository.delete(order);

        return _order;

    }

    /**
     * Get a seat by the row and column
     * 
     * @param seat Seat
     * @return Seat
     * @throws OrderException if the row or column is out of bounds
     * 
     */

    @Override
    public Seat getSeatByRowAndColumn(@RequestBody Seat seat) {
        return seatRepository.findByRowAndColumn(seat.getRow(), seat.getColumn())
                .orElseThrow(() -> new OrderException("The number of a row or a column is out of bounds!"));
    }

}
