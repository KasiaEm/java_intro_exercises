package com.sda.ex2;

public class PerfectNumberCalculator {

    public static void main(String[] args) {
        //System.out.println(isPerfectNumber(24));

        showPerfectNumbersToMaxNumber(100000);
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        if (number % 2 == 1)
            return false;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
                if (sum > number) {
                    return false;
                }
            }
        }
        return sum == number;
    }

    public static void showPerfectNumbersToMaxNumber(int max) {
        System.out.println("Perfect numbers:");
        for (int i = 2; i <= max; i++) {
            if (isPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }

}
