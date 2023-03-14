package com.example.store.store.controller;

import com.example.store.store.domain.dto.ProductCreateDto;
import com.example.store.store.domain.dto.ProductDto;
import com.example.store.store.domain.jpa.Product;
import com.example.store.store.mapper.Mapper;
import com.example.store.store.service.ProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    return ResponseEntity.ok(productService.getAll()
        .stream().map(product -> Mapper.mapToProductDto(product)).toList());
  }

  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto productCreateDto) {
    Product productToCreate = Mapper.mapToProduct(productCreateDto);
    Product persistedProduct = productService.create(productToCreate);

    return new ResponseEntity<>(Mapper.mapToProductDto(persistedProduct), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public void deleteProductById(@PathVariable Integer id) {
    productService.deleteById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProduct(@PathVariable Integer id,
      @RequestBody ProductCreateDto productCreateDto) {
    Product productToUpdate = Mapper.mapToProduct(productCreateDto);
    Product updatedProduct = productService.update(id, productToUpdate);
    
    return new ResponseEntity<>(Mapper.mapToProductDto(updatedProduct), HttpStatus.OK);
  }

}
