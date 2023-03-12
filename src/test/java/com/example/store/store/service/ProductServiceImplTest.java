package com.example.store.store.service;

import com.example.store.store.domain.jpa.Product;
import com.example.store.store.repository.ProductRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author : Xenofon Zinoviou
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

  @Mock
  private ProductRepository productRepository;

  private ProductServiceImpl testClass;


  @BeforeEach
  void init() {
    testClass = new ProductServiceImpl(productRepository);
  }


  @Test
  void findById_whenProductExists_thenReturnResult() {
    Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(newProduct()));
    Product result = testClass.getById(1);

    Assertions.assertEquals(1, result.getId());
    Assertions.assertEquals("a product", result.getName());
    Assertions.assertEquals(100, result.getPrice());
  }

  private static Product newProduct() {
    Product product = new Product();
    product.setId(1);
    product.setName("a product");
    product.setPrice(100);
    return product;
  }
}
