package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;

import com.farvic.cinemaroom.domain.Token;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public interface SeatService {

    public List<Seat> getAllSeats();

    public Order purchaseSeat(Seat seat);

    public Order refundTicket(Token token);

    public Seat getSeatByRowAndColumn(@RequestBody Seat seat);

}
