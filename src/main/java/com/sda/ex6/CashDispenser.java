package com.sda.ex6;

public class CashDispenser {
    private static int denomination[] = new int[]{200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        dispenseCashSimple(587);
    }

    public static void dispenseCashSimple(int amount) {
        int i = 0;
        while (amount > 0) {
            int d = denomination[i];
            System.out.println(amount / d + " x " + d);
            amount %= d;
            i++;
        }
    }

}
