package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Stats;
import com.farvic.cinemaroom.domain.Token;

import com.farvic.cinemaroom.service.OrderService;

import com.farvic.cinemaroom.errors.OrderException;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class OrderController {

    // private static final Logger LOGGER =
    // LoggerFactory.getLogger(OrderRepository.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/stats")
    public Stats statsEndpoint(@RequestParam(required = false) String password) throws OrderException {
        return orderService.getStats(password);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}
