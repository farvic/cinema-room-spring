package com.farvic.cinemaroom.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "SEAT")
public class Seat {
    @Id
    private int row;
    private int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    protected Seat() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}