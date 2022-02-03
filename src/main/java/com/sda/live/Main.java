package com.sda.live;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee boss = new Employee("Boss");

        Employee e1 = new Employee("Anna");
        Employee e2 = new Employee("Mark");

        boss.setEmployees(new Employee[]{e1, e2});

        Employee e3 = new Employee("John");

        e1.setEmployees(new Employee[]{e3});

        Employee e4 = new Employee("John");

        e2.setEmployees(new Employee[]{e4});

        boss.showAllSubordinates();
    }
}
