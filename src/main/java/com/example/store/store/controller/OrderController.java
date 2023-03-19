package com.example.store.store.controller;

import com.example.store.store.model.dto.CreateOrderWrapper;
import com.example.store.store.model.dto.OrderProductDto;
import com.example.store.store.model.entity.Order;
import com.example.store.store.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderWrapper createOrderWrapper) {

        return new ResponseEntity<>(orderService.create(createOrderWrapper), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Integer id) {
        orderService.deleteById(id);
    }
}
