package com.sda.ex5;

public class BinaryNumbers {

    public static void main(String[] args) {
        int normalNumber = binaryToNormal("1011");
        System.out.println(normalNumber);

        String binary = normalToBinary(normalNumber);
        System.out.println(binary);
    }

    public static int binaryToNormal(String binNumber) {
        int result = 0;
        int power = 0;
        char chars[] = binNumber.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }
        return result;
    }

    public static String normalToBinary(int norNumber) {
        String result = "";
        while (norNumber > 0) {
            result = (norNumber % 2) + result;
            norNumber /= 2;
        }
        return result;
    }
}
