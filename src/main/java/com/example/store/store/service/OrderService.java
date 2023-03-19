package com.example.store.store.service;
import com.example.store.store.model.dto.CreateOrderWrapper;
import com.example.store.store.model.dto.OrderProductDto;
import com.example.store.store.model.entity.Order;
import java.util.List;
import java.util.Set;

public interface OrderService {
    //Order create(Order order);

    Order create(CreateOrderWrapper createOrderWrapper);

    Order getById(Integer id);

    List<Order> getAll();

    void deleteById(Integer id);
}
