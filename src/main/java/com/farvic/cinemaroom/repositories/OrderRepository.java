package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
        Order findByToken(String token);
}
