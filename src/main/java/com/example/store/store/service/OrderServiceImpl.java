package com.example.store.store.service;

import com.example.store.store.model.dto.CreateOrderWrapper;
import com.example.store.store.model.dto.OrderProductDto;
import com.example.store.store.model.entity.Order;
import com.example.store.store.model.entity.Product;
import com.example.store.store.repository.OrderRepository;
import com.example.store.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Order create(CreateOrderWrapper createOrderWrapper) {
        Order order = new Order();
        BigDecimal tp =new BigDecimal(0);
        for(OrderProductDto dto : createOrderWrapper.orderProductDtoSet) {
           Product product = productRepository.findById(dto.getProductId()).orElseThrow();
           tp = tp.add(product.getPrice().multiply(dto.getQuantity()));
        }
        order.setTotalPrice(tp);
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
