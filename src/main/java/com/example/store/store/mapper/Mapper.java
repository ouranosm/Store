package com.example.store.store.mapper;

import com.example.store.store.domain.dto.ProductCreateDto;
import com.example.store.store.domain.dto.ProductDto;
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

  public static ProductDto mapToProductDto(Product product) {
    ProductDto productDto = new ProductDto();
    productDto.setId(product.getId());
    productDto.setName(product.getName());
    productDto.setPrice(product.getPrice());
    return productDto;
  }
}
