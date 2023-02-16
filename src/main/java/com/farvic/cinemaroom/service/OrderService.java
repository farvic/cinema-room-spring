package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.Order;

import com.farvic.cinemaroom.domain.Stats;

import java.util.List;

public interface OrderService {

    public List<Order> getOrders();

    public Stats getStats(String password);
}
