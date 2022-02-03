package com.sda.ex11;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
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
    private String secretWord;
    private char word[];
    private int allowedMistakes = 5;
    private boolean win = false;

    public void start() {
        secretWord = words[new Random().nextInt(words.length)];
        word = generateEmptyWord(secretWord.length());
        game();
    }

    private void game() {
        int missingLetters = secretWord.length();
        while (allowedMistakes >= 0 && missingLetters > 0) {
            showWord();
            showAllowedMistakes(allowedMistakes);
            System.out.print("Guess letter: ");
            String letter = new Scanner(System.in).next();
            if (secretWord.contains(letter)) {
                char c = letter.charAt(0);
                for (int i = 0; i < secretWord.length(); i++) {
                    if(secretWord.charAt(i)==c){
                        word[i]=c;
                        missingLetters--;
                        if (missingLetters==0){
                            win=true;
                            break;
                        }
                    }
                }
            } else {
                allowedMistakes--;
            }
        }
        System.out.println("The word: " + secretWord);
        System.out.println(win? "You've won." : "You've lost.");
    }

    private static void showAllowedMistakes(int allowedMistakes) {
        for (int i=0; i<5-allowedMistakes; i++){
            System.out.print("X");
        }
        System.out.println();
    }

    private void showWord() {
        for (char c : word){
            System.out.print(c);
        }
        System.out.println();
    }

    private static char[] generateEmptyWord(int length) {
        char result[] = new char[length];
            for(int i=0; i<length; i++){
                result[i]='.';
            }
        return result;
    }


}
