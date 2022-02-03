package com.sda.ex1;

import java.util.Scanner;

import static com.sda.ex1.BMIStatus.calculateBMI;

public class BMIManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter you weigth [kg]: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter you height [m]: ");
        double height = scanner.nextDouble();

        BMIStatus bmiStatus = calculateBMI(weight, height);

        System.out.println(bmiStatus.getMessage());
    }
}
