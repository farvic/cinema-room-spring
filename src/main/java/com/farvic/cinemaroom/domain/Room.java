package com.farvic.cinemaroom.domain;

import java.util.List;

public class Room {

    private int totalRows;

    private int totalColumns;

    private List<SeatDto> seats;

    public Room(List<SeatDto> seats) {
        this.totalRows = 9;
        this.totalColumns = 9;
        this.seats = seats;
    }

    protected Room() {

    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<SeatDto> getSeats() {
        return seats;

    }

    public List<SeatDto> setSeats() {
        return seats;
    }
}
