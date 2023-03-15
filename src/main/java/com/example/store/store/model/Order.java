package com.example.store.store.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double price;

    @ManyToMany
    Set<Customer> ordersCustomer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Customer> getOrdersCustomer() {
        return ordersCustomer;
    }

    public void setOrdersCustomer(Set<Customer> ordersCustomer) {
        this.ordersCustomer = ordersCustomer;
    }
}
