package com.example.store.store.mapper;

import com.example.store.store.domain.dto.ProductCreateDto;
import com.example.store.store.domain.jpa.Product;

/**
 * @author : Xenofon Zinoviou
 */
public class Mapper {

  private Mapper() {
  }

  public static Product mapToProduct(ProductCreateDto productCreateDto) {
    Product product = new Product();
    product.setName(productCreateDto.getName());
    product.setPrice(productCreateDto.getPrice());
    return product;
  }

}
