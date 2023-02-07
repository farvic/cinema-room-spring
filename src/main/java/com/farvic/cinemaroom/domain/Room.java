package com.farvic.cinemaroom.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private int totalRows;
    private int totalColumns;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Seat> availableSeats;

    public Room(int totalRows, int totalColumns, List<Seat> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    protected Room() {

    }

    public Long getId() {
        return id;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
