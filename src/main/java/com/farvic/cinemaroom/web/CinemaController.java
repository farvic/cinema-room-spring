package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Cinema;

import com.farvic.cinemaroom.service.CinemaService;

import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema getCinemaSeats() {
        return cinemaService.getCinemaSeats();
    }

}