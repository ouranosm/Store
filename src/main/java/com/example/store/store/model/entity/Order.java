package com.example.store.store.model.entity;

import com.example.store.store.model.dto.OrderProductDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    Set<OrderProductDto> orderProduct= new HashSet<>();

    public Set<OrderProductDto> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProductDto> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


}
