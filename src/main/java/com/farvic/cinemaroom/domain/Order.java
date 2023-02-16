package com.farvic.cinemaroom.domain;

import com.farvic.cinemaroom.utils.OrderSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orders")
@JsonSerialize(using = OrderSerializer.class)
public class Order {
    @Id
    @Column(name = "token")
    private String token;

    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    @OneToOne(cascade = CascadeType.ALL)

    private Seat ticket;

    @JsonIgnore
    @Transient
    private boolean isReturn = false;

    public Order() {
    }

    public Order(Seat ticket) {
        this.ticket = ticket;
        this.token = UUID.randomUUID().toString();
    }

    public Order(String token, Seat ticket, boolean isReturn) {
        this.token = token;
        this.ticket = ticket;
        this.isReturn = isReturn;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }

    @Override
    public String toString() {
        return "Order{" +
                "token=" + token +
                ", ticket=" + ticket +
                '}';
    }
}
