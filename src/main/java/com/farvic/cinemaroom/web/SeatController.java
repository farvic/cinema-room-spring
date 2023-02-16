package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Token;
import com.farvic.cinemaroom.repositories.CinemaRepository;

import com.farvic.cinemaroom.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:28852")
@RestController
public class SeatController {

    private final SeatService seatService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CinemaRepository.class);

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats-list")
    public List<Seat> getAvailableSeats() {
        return seatService.getAllSeats();
    }

    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    public Order purchaseSeat(@RequestBody Seat seat) {
        return seatService.purchaseSeat(seat);
    }

    @PostMapping("/return")
    public Order refundTicket(@RequestBody Token token) {
        return seatService.refundTicket(token);
    }

    @GetMapping("/seat")
    public Seat getSeatByRowAndColumn(@RequestBody Seat seat) {
        return seatService.getSeatByRowAndColumn(seat);
    }

}