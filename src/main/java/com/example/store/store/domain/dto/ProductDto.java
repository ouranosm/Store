package com.example.store.store.domain.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Xenofon Zinoviou
 */
public class ProductDto implements Serializable {

  private Integer id;

  private String name;

  private double price;

  public ProductDto() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto that = (ProductDto) o;
    return Double.compare(that.price, price) == 0 && id.equals(that.id)
        && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }

  @Override
  public String toString() {
    return "ProductDto{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
