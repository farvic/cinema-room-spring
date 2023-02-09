// package com.farvic.cinemaroom.domain;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;

// @Entity
// public class Room {
// @Id
// @GeneratedValue
// private Long id;

// private int totalRows;
// private int totalColumns;

// private List<Seat> seats;

// public Room(int totalRows, int totalColumns, List<Seat> seats) {
// this.totalRows = totalRows;
// this.totalColumns = totalColumns;
// this.seats = seats;
// }

// protected Room() {

// }

// public int getId() {
// return id;
// }

// public int getTotalRows() {
// return totalRows;
// }

// public int getTotalColumns() {
// return totalColumns;
// }

// public List<Seat> getSeats() {
// return seats;
// }
// }
