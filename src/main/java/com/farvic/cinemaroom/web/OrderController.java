package com.farvic.cinemaroom.web;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Stats;
import com.farvic.cinemaroom.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.farvic.cinemaroom.errors.OrderException;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Tag(name = "Order", description = "Order API")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Part 4 task: Get the cinema stats

    @Operation(summary = "Get stats", description = "Get the cinema stats: current income, tickets purchased and available seats", tags = {
            "Order" })
    @ApiResponse(responseCode = "200", description = "OK")
    @PostMapping("/stats")
    public Stats statsEndpoint(@RequestParam(required = false) String password) throws OrderException {
        return orderService.getStats(password);
    }

    @Operation(summary = "Get all orders", description = "Get all the orders", tags = {
            "Order" })
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}
