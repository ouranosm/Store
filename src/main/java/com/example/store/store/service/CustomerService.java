package com.example.store.store.service;

import com.example.store.store.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);

    Customer getById(Integer id);

    List<Customer> getAll();

    void deleteById(Integer id);
}
