package com.sda.ex10;

import java.util.Random;

public class ScrabbleWordGenerator {

    public static void main(String[] args) {
        System.out.println(generate('A', 'B', 'G', 'N', 'O'));
    }

    public static String generate(char... letters) {
        char chars[] = new char[letters.length];
        Random random = new Random();

        for (char letter : letters) {
            boolean notEmpty = false;
            do {
                notEmpty = false;
                int index = random.nextInt(letters.length);
                if (chars[index] != (char) 0) {
                    notEmpty = true;
                } else {
                    chars[index] = letter;
                    notEmpty = false;
                }
            } while (notEmpty);
        }

        return String.valueOf(chars);
    }
}
