package com.example.store.store.service;

import com.example.store.store.model.Customer;

import com.example.store.store.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer with id: " + id + " not found"));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete customer with id: " + id);
        }
    }
}
