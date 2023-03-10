package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.Cinema;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.repositories.CinemaRepository;
import com.farvic.cinemaroom.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("CinemaServiceImpl")
@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final SeatRepository seatRepository;

    /**
     * Construct CinemaService
     *
     * @param cinemaRepository Cinema Repository
     * @param seatRepository   Seat Repository
     *
     */

    public CinemaServiceImpl(CinemaRepository cinemaRepository, SeatRepository seatRepository) {
        this.cinemaRepository = cinemaRepository;
        this.seatRepository = seatRepository;
    }

    /**
     * Get only the available seats in the cinema and returns the cinema object
     * with the total number of rows, columns and available seats
     * 
     * * Example 1 output
     *
     * @return Cinema
     * @throws ResourceNotFoundException if the cinema is closed
     *
     */

    @Override
    public Cinema getCinemaSeats() {

        Cinema cinema = cinemaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("The cinema is closed"));

        List<Seat> seats = seatRepository.findByCinemaIdAndIsAvailable(1, true);

        cinema.setAvailableSeats(seats);

        return cinema;
    }
}
