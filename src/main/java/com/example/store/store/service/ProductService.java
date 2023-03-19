package com.example.store.store.service;

import com.example.store.store.model.dto.OrderProductDto;
import com.example.store.store.model.entity.Product;
import com.example.store.store.model.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(Integer id);

    List<Product> getAll();

    void deleteById(Integer id);

    void update(Integer id, ProductUpdateDto productUpdateDto);
}
