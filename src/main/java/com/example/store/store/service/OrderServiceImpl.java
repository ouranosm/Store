package com.example.store.store.service;

import com.example.store.store.model.Order;
import com.example.store.store.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order with id: " + id + " not found"));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete order with id: " + id);
        }
    }
}
