package com.example.store.store.service;

import com.example.store.store.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Integer productId);

    List<Product> getAllProducts();

    void deleteProductById(Integer productId);
}
