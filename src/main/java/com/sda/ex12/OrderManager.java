package com.sda.ex12;

import java.time.LocalDateTime;
import java.time.Month;

public class OrderManager {
    private static Order orders[];

    public static void main(String[] args) {
        prepareData();

        ClientType clientType = ClientType.BUSINESS;
        System.out.println("------------------------------------------");
        System.out.println("ORDERS BY CLIENT TYPE: " + clientType);
        System.out.println("------------------------------------------");
        filterByClientType(clientType);

        LocalDateTime date = LocalDateTime.of(2020, Month.JANUARY, 1, 1, 1, 1);
        System.out.println("------------------------------------------");
        System.out.println("ORDERS BY date: " + date);
        System.out.println("------------------------------------------");
        filterByClientDate(date);

        double costFrom = 1000d;
        double costTo = 4000d;
        System.out.println("------------------------------------------");
        System.out.println("ORDERS BY cost from: " + costFrom + " to: " + costTo);
        System.out.println("------------------------------------------");
        filterByCost(costFrom, costTo);

        int productsCount = 3;
        System.out.println("------------------------------------------");
        System.out.println("ORDERS BY products count: " + productsCount);
        System.out.println("------------------------------------------");
        filterByProductsCount(productsCount);

        Country country = Country.NL;
        System.out.println("------------------------------------------");
        System.out.println("ORDERS BY products country: " + country);
        System.out.println("------------------------------------------");
        filterByProductsCountry(country);
    }

    private static void filterByProductsCountry(Country country) {
        for (Order order : orders) {
            if (order.containsProductFromCountry(country)) {
                System.out.println(order);
            }
        }
    }

    private static void filterByProductsCount(int productsCount) {
        for (Order order : orders) {
            if (order.getProductsCout()==productsCount) {
                System.out.println(order);
            }
        }
    }

    private static void filterByCost(double costFrom, double costTo) {
        for (Order order : orders) {
            if (order.getTotalCost() > costFrom && order.getTotalCost() < costTo) {
                System.out.println(order);
            }
        }
    }

    private static void filterByClientDate(LocalDateTime dateFrom) {
        for (Order order : orders) {
            if (order.getCreated().isAfter(dateFrom)) {
                System.out.println(order);
            }
        }
    }

    private static void filterByClientType(ClientType clientType) {
        for (Order order : orders) {
            if (order.getClientType() == clientType) {
                System.out.println(order);
            }
        }
    }

    private static void prepareData() {
        Order order1 = new Order();
        order1.setClientType(ClientType.BUSINESS);
        order1.setProducts(new Product[]{
                new Product("Chair B", 12, 50d, Country.NL),
                new Product("Table A", 4, 100.99, Country.FR),
                new Product("Lamp XYZ", 4, 30.5, Country.NL)
        });
        Order order2 = new Order();
        order2.setClientType(ClientType.PRIVATE);
        order2.setProducts(new Product[]{
                new Product("Plant Ficus", 2, 14.99, Country.SP),
                new Product("Sofa", 1, 800d, Country.PL),
                new Product("Candles", 30, 1.5, Country.GE)
        });
        Order order3 = new Order();
        order3.setClientType(ClientType.BUSINESS);
        order3.setProducts(new Product[]{
                new Product("Plant Epipremnum", 30, 12.99, Country.GB),
                new Product("Cabinet", 15, 80d, Country.GB)
        });
        orders = new Order[]{order1, order2, order3};
    }
}
