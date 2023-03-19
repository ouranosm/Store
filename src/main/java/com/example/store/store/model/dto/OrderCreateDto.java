package com.example.store.store.model.dto;

import java.util.List;

public class OrderCreateDto {
    private double totalPrice;
    private List<OrderProductDto> orderProductDto;

    public OrderCreateDto(double totalPrice, List<OrderProductDto> orderProductDto) {
        this.totalPrice = totalPrice;
        this.orderProductDto = orderProductDto;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderProductDto> getOrderProductDto() {
        return orderProductDto;
    }

    public void setOrderProductDto(List<OrderProductDto> orderProductDto) {
        this.orderProductDto = orderProductDto;
    }
}
