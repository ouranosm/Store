package com.example.store.store.model.dto;

import com.example.store.store.model.entity.Order;
import org.springframework.data.domain.Sort;

import java.util.Set;

public class CreateOrderWrapper {
    public String address;

    public Set<OrderProductDto> orderProductDtoSet;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<OrderProductDto> getOrderProductDtoSet() {
        return orderProductDtoSet;
    }

    public void setOrderProductDtoSet(Set<OrderProductDto> orderProductDtoSet) {
        this.orderProductDtoSet = orderProductDtoSet;
    }
}
