package com.example.store.store.service;

import com.example.store.store.domain.dto.ProductCreateDto;
import com.example.store.store.domain.jpa.Product;
import com.example.store.store.mapper.Mapper;
import com.example.store.store.repository.ProductRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product create(ProductCreateDto productCreateDto) {
    Product product = Mapper.mapToProduct(productCreateDto);
    return productRepository.save(product);
  }

  @Override
  public Product getById(Integer id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found"));
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    try {
      productRepository.deleteById(id);
    } catch (RuntimeException ex) {
      final String message = String.format("Could not delete product with id: %d", id);
      LOGGER.info(message);
    }
  }

  @Override
  public Product update(Integer id, ProductCreateDto productCreateDto) {
    Product persistedProduct = productRepository.findById(id).orElseThrow();

    Product productToUpdate = Mapper.mapToProduct(productCreateDto);
    productToUpdate.setId(persistedProduct.getId());

    return productRepository.save(productToUpdate);
  }

}
