package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Cinema;

import com.farvic.cinemaroom.service.CinemaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

@Tag(name = "Cinema", description = "Cinema API")
@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    // Example 1 task: Get cinema with available seats

    @Operation(summary = "Get the Cinema and available seats", description = "Get the cinema with available seats, total rows and columns", tags = {
            "Cinema" })
    @ApiResponse(responseCode = "200", description = "Cinema and available seats")
    @GetMapping("/seats")
    public Cinema getCinemaSeats() {
        return cinemaService.getCinemaSeats();
    }

}