package com.example.store.store.service;

import com.example.store.store.model.Product;
import com.example.store.store.model.ProductUpdater;
import com.example.store.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product with id: " + id + " not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete product with id: " + id);
        }
    }

    @Override
    public void update(Integer id, ProductUpdater productUpdater) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setPrice(productUpdater.price);
        product.setName(productUpdater.name);
        productRepository.save(product);
    }


}
