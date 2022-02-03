package com.sda.ex12;

import java.time.LocalDateTime;

public class Product {
    private String name;
    private Integer count;
    private Double price;
    private Country country;

    public Product() {
    }

    public Product(String name, Integer count, Double price, Country country) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{" + name + "- " + count + "x, " + price + ", " + country + '}';
    }
}
