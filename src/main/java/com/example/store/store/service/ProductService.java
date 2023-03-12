package com.example.store.store.service;

import com.example.store.store.model.Product;
import com.example.store.store.model.ProductUpdater;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(Integer id);

    List<Product> getAll();

    void deleteById(Integer id);

    void update(Integer id, ProductUpdater productUpdater);
}
