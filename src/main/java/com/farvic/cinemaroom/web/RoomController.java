package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Room;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.repo.RoomRepo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    private RoomRepo cinemaRoomRepository;

    @GetMapping("/seats")
    public Room getSeats() {
        List<Seat> availableSeats = Arrays.asList(
                new Seat(1, 1),
                new Seat(5, 5),
                new Seat(5, 6));

        Room cinemaRoom = new Room(5, 6, availableSeats);
        return cinemaRoomRepository.save(cinemaRoom);
    }
}
