package com.example.store.store.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;



//    @ManyToMany
//    @JoinTable(
//            name =  "customerOrders",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "orders_id")
//    )
//    Set<Order> customerOrders;

//    public Set<Order> getCustomerOrders() {
//        return customerOrders;
//    }
//
//    public void setCustomerOrders(Set<Order> customerOrders) {
//        this.customerOrders = customerOrders;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
