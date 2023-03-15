package com.example.store.store.service;
import com.example.store.store.model.Order;
import java.util.List;

public interface OrderService {
    Order create(Order order);

    Order getById(Integer id);

    List<Order> getAll();

    void deleteById(Integer id);
}
