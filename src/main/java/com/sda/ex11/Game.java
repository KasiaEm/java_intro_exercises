package com.sda.ex11;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static String words[] = {"enum",
            "constructor",
            "class",
            "main",
            "static",
            "private",
            "void",
            "type",
            "object",
            "array",
            "integer"
    };
    private static int allowedMistakes = 5;
    private String secretWord;
    private char userWord[];
    private boolean win = false;
    private String mistakes = "";
    private Scanner sc = new Scanner(System.in);

    public void start() {
        init();
        System.out.println("Let the game begin...");

        do {
            System.out.println(String.valueOf(userWord));
            if (!mistakes.isEmpty())
                System.out.println(mistakes);
            char choice = sc.nextLine().charAt(0);

            if (secretWord.contains("" + choice)) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == choice)
                        userWord[i] = choice;
                }
            } else {
                mistakes += "X";
            }
            if (!String.valueOf(userWord).contains("."))
                win = true;
        } while (!win && mistakes.length() < allowedMistakes);

        System.out.println(win ? "You won!" : "You lost!");
    }

    private void init() {
        secretWord = words[new Random().nextInt(words.length)];
        userWord = new char[secretWord.length()];
        for (int i = 0; i < userWord.length; i++) {
            userWord[i] = '.';
        }
    }
}
