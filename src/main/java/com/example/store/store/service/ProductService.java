package com.example.store.store.service;

import com.example.store.store.domain.jpa.Product;
import java.util.List;

public interface ProductService {

  Product create(Product product);

  Product getById(Integer id);

  List<Product> getAll();

  void deleteById(Integer id);

  Product update(Integer id, Product product);
}
