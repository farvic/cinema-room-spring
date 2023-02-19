package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Order;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Order", description = "Order API")
public interface OrderRepository extends JpaRepository<Order, String> {
        /**
         * Find order by token
         * 
         * @param token
         * @return
         */
        Order findByToken(@Param("token") String token);
}
