package com.sda.ex9;

import java.util.Random;

public class LottoSimulation {
    private static int numbers[] = new int[6];
    private static double singleCost = 3d;
    private static double budget = 0d;
    private static int winners[] = new int[7];
    private static int customersTotal = 0;
    private static double prize3 = 0;
    private static double prize4 = 0;
    private static double prize5 = 0;
    private static double prize6 = 0;


    public static void main(String[] args) {
        initSimulation(1000000);
        printStatistics();
    }

    private static void printStatistics() {
        System.out.println("Total customers: " + customersTotal);
        System.out.println("Single cost: " + singleCost);
        System.out.println("Total budget: " + budget);

        System.out.println("Prize for 3 hits: " + prize3);
        System.out.println("Prize for 4 hits: " + prize4);
        System.out.println("Prize for 5 hits: " + prize5);
        System.out.println("Prize for 6 hits: " + prize6);

        System.out.println("Lucky numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println("Hits: ");
        for (int i = 0; i < winners.length; i++) {
            System.out.println(winners[i] + " x " + i + "hits");
        }
    }

    private static void initSimulation(int customersNr) {
        customersTotal = customersNr;
        budget = customersTotal * singleCost;
        numbers = generateNumbers();

        for (int i = 0; i < customersTotal; i++) {
            int customerNumbers[] = generateNumbers();
            int hits = checkHits(customerNumbers);
            winners[hits]++;
        }

        prize3 = 0.05 * budget / winners[3];
        prize4 = 0.05 * budget / winners[4];
        prize5 = 0.1 * budget / winners[5];
        prize6 = 0.8 * budget / winners[6];
    }

    private static int checkHits(int[] customerNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == customerNumbers[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int[] generateNumbers() {
        System.out.println("Generating numbers...");
        int temp[] = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boolean duplicated = false;
            do {
                duplicated = false;
                temp[i] = new Random().nextInt(49) + 1;
                for (int j = 0; j < i; j++) {
                    if (temp[i] == temp[j]) {
                        duplicated = true;
                        break;
                    }
                }
            } while (duplicated);
        }
        return temp;
    }

}
