package com.example.session15lesson2.controller;

import com.example.session15lesson2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{orderId}/cancel")
    public String cancel(@PathVariable Long orderId) {
        return orderService.cancelOrder(orderId);
    }
}
