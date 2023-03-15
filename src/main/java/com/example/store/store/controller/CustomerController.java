package com.example.store.store.controller;

import com.example.store.store.model.Customer;
import com.example.store.store.model.Order;
import com.example.store.store.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteById(id);
    }
}
