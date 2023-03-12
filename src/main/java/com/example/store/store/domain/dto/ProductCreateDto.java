package com.example.store.store.domain.dto;

/**
 * @author : Xenofon Zinoviou
 */
public class ProductCreateDto {

  private String name;

  private double price;

  public ProductCreateDto() {
  }

  public ProductCreateDto(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
