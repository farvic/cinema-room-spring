package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Token;

import com.farvic.cinemaroom.service.SeatService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:28852")
@RestController
@Tag(name = "Seat", description = "Seat API")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @Operation(summary = "Get all seats", description = "Get all seats, available or not", tags = {
            "Seat" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/seats-list")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @Operation(summary = "Purchase a seat", description = "Purchase a seat and get an order, with the ticket(seat) and an UUID token", tags = {
            "Seat" })
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    public Order purchaseSeat(@RequestBody Seat seat) {
        return seatService.purchaseSeat(seat);
    }

    @Operation(summary = "Return a ticket", description = "Return a ticket, refund money and leave the seat available again", tags = {
            "Seat" })
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping("/return")
    public Order refundTicket(@RequestBody Token token) {
        return seatService.refundTicket(token);
    }

    @Operation(summary = "Get a seat by row and column", description = "Get a seat by row and column", tags = {
            "Seat" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/seat")
    public Seat getSeatByRowAndColumn(@RequestBody Seat seat) {
        return seatService.getSeatByRowAndColumn(seat);
    }

}