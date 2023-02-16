package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.*;
import com.farvic.cinemaroom.repositories.OrderRepository;
import com.farvic.cinemaroom.repositories.SeatRepository;
import com.farvic.cinemaroom.errors.OrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("OrderServiceImpl")
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final SeatRepository seatRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRepository.class);

    public OrderServiceImpl(OrderRepository orderRepository, SeatRepository seatRepository) {
        this.orderRepository = orderRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Stats getStats(String password) {

        int numberOfPurchasedTickets;
        int currentIncome = 0;
        int numberOfAvailableSeats;

        if (password == null || !password.equals("super_secret")) {
            throw new OrderException("The password is wrong!", HttpStatus.UNAUTHORIZED);
        }
        LOGGER.info("Password is correct");

        List<Order> order = orderRepository.findAll();

        numberOfPurchasedTickets = order.size();

        numberOfAvailableSeats = 81 - numberOfPurchasedTickets;

        for (Order o : order) {
            currentIncome += o.getTicket().getPrice();
        }
        return new Stats(currentIncome, numberOfAvailableSeats, numberOfPurchasedTickets);
    }
}
