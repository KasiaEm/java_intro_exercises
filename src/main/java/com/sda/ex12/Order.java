package com.sda.ex12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Order {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Product[] products;
    private LocalDateTime created;
    private ClientType clientType;
    private Double totalCost;

    public Order() {
        products = new Product[10];
        created = LocalDateTime.now();
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
        countTotalCost();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Order addProduct(Product product) {
        boolean added = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                added = true;
            }
        }
        if (!added) {
            System.out.println("Couldn't add product. No more space.");
        } else {
            countTotalCost();
        }
        return this;
    }

    private void countTotalCost() {
        double total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getCount() * product.getPrice();
            }
        }
        this.totalCost = total;
        System.out.println("Updated cost.");
    }

    public int getProductsCout(){
        int count = 0;
        for(Product product : products){
            if(product!=null){
                count++;
            }
        }
        return count;
    }

    public boolean containsProductFromCountry(Country country){
        for (Product product: products){
            if (product!=null && product.getCountry().equals(country)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\nprods=" + Arrays.toString(products) +
                ", \ncreated:" + created.format(formatter) +
                ", \ntype:" + clientType +
                ", \ncost:" + totalCost +
                "\n}";
    }
}
