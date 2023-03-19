package com.example.store.store.model.entity;

import com.example.store.store.model.dto.OrderProductDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;


@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private BigDecimal totalPrice;
    //@OneToMany

//    public List<OrderProductDto> orderProductDtoList;
//
//    public List<OrderProductDto> getOrderProductDtoList() {
//        return orderProductDtoList;
//    }
//
//    public void setOrderProductDtoList(List<OrderProductDto> orderProductDtoList) {
//        this.orderProductDtoList = orderProductDtoList;
//    }

    //    @OneToMany(mappedBy = "order")
//    Set<Product> products;
//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }



//    @ManyToMany(mappedBy = "customerOrders")
//    Set<Customer> customerSet;

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

//    public Set<Customer> getOrdersCustomer() {
//        return customerSet;
//    }
//
//    public void setCustomerSet(Set<Customer> customerSet) {
//        this.customerSet = customerSet;
//    }
}
