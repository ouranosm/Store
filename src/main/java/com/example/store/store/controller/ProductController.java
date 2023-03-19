package com.example.store.store.controller;

import com.example.store.store.model.dto.OrderProductDto;
import com.example.store.store.model.entity.Product;
import com.example.store.store.model.dto.ProductUpdateDto;
import com.example.store.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping("/{id}")
    public void updateProduct(@PathVariable Integer id,@RequestBody ProductUpdateDto productUpdateDto) {

        productService.update(id, productUpdateDto);
    }



}
