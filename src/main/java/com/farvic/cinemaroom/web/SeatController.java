package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.SeatDto;
import com.farvic.cinemaroom.repo.SeatRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;

// @CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    SeatRepository seatRepository;

    // private static final Logger LOGGER =
    // LoggerFactory.getLogger(SeatRepository.class);

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        // try {
        List<Seat> seats = new ArrayList<Seat>();

        seatRepository.findAll().forEach(seats::add);
        // else
        // seatRepository.findByTitleContaining(title).forEach(seats::add);

        if (seats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(seats, HttpStatus.OK);
        // } catch (Exception e) {
        // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Seat> getSeatById(@PathVariable("id") long id) {
    // Optional<Seat> seatData = seatRepository.findById(id);

    // if (seatData.isPresent()) {
    // return new ResponseEntity<>(seatData.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @PostMapping("/seats")
    // public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
    // try {
    // Seat _seat = seatRepository
    // .save(new Seat(seat.getRow(), seat.getColumn(), seat.isAvailable()));
    // return new ResponseEntity<>(_seat, HttpStatus.CREATED);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @PutMapping("/seats/{id}")
    // public ResponseEntity<Seat> updateSeat(@PathVariable("id") long id,
    // @RequestBody Seat seat) {
    // Optional<Seat> seatData = seatRepository.findById(id);

    // if (seatData.isPresent()) {
    // Seat _seat = seatData.get();
    // _seat.setRow(seat.getRow());
    // _seat.setColumn(seat.getColumn());
    // _seat.setAvailable(seat.isAvailable());
    // return new ResponseEntity<>(seatRepository.save(_seat), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @DeleteMapping("/seats/{id}")
    // public ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") long id) {
    // try {
    // seatRepository.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/seats")
    // public ResponseEntity<HttpStatus> deleteAllSeats() {
    // try {
    // seatRepository.deleteAll();
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    // }

    // @GetMapping("/available")
    // public ResponseEntity<List<Seat>> findByAvailability() {
    // try {
    // List<Seat> seats = seatRepository.findAllByIsAvailable(true);
    //
    // if (seats.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    // return new ResponseEntity<>(seats, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // Gets the available seats and returns them as a list of SeatDto objects (row,
    // column)
    @GetMapping("/available")
    public ResponseEntity<List<SeatDto>> findByAvailability() {
        try {
            List<SeatDto> seats = new ArrayList<SeatDto>();

            seatRepository.findAllByIsAvailable(true).forEach((seat) -> {
                seats.add(new SeatDto(seat.getRow(), seat.getColumn()));
            });

            if (seats.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(seats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}