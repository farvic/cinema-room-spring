// package com.farvic.cinemaroom.web;

// import com.farvic.cinemaroom.domain.Room;
// import com.farvic.cinemaroom.domain.Seat;
// import com.farvic.cinemaroom.dto.SeatDTO;
// import com.farvic.cinemaroom.repo.RoomRepo;

// import java.util.Arrays;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/rooms")
// public class RoomController {

// private final RoomRepo roomRepository;

// public RoomController(RoomRepo roomRepository) {
// this.roomRepository = roomRepository;
// }

// // @GetMapping
// // public List<Room> getAllRooms() {
// // return roomRepository.findAll();
// // }

// // @GetMapping("/{id}")
// // public Room getRoomById(@PathVariable int id) {
// // return roomRepository.findById(id).orElse(null);
// // }

// // @PutMapping("/{id}")
// // public Room updateSeatAvailability(@PathVariable int id, @RequestBody
// SeatDTO
// // seatDTO) {
// // Room room = roomRepository.findById(id).orElse(null);
// // if (room != null) {
// // Seat seat = room.getSeats().stream()
// // .filter(s -> s.getRow() == seatDTO.getRow() && s.getColumn() ==
// // seatDTO.getColumn())
// // .findFirst()
// // .orElse(null);
// // if (seat != null) {
// // seat.setAvailable(seatDTO.isAvailable());
// // roomRepository.save(room);
// // }
// // }
// // return room;
// // }
// }
