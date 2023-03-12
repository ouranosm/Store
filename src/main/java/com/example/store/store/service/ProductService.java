package com.example.store.store.service;

import com.example.store.store.domain.dto.ProductCreateDto;
import com.example.store.store.domain.jpa.Product;

import java.util.List;

public interface ProductService {

    Product create(ProductCreateDto productCreateDto);

    Product getById(Integer id);

    List<Product> getAll();

    void deleteById(Integer id);

    Product update(Integer id, ProductCreateDto productCreateDto);
}
