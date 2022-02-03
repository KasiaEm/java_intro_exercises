package com.sda.ex4;

public class Censored {

    public static void main(String[] args) {
        String text = "Local woman - Alicia Smith is accused of murder on John Black.";

        System.out.println(censoreNames(text));
        System.out.println(censoreNameRegExp(text));
    }

    public static String censoreNames(String text) {
        String words[] = text.split(" ");
        String result = words[0];

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char firstLetter = word.charAt(0);
            if (firstLetter >= 'A' && firstLetter <= 'Z') {
                word = firstLetter + createLongCensorship(word.length());
            }
            result += " " + word;
        }
        return result;
    }

    private static String createLongCensorship(int length) {
        String result = "";
        for (int i = 0; i < length - 1; i++) {
            result += "*";
        }
        return result;
    }

    public static String censoreNameRegExp(String text) {
        String namePattern = "[A-Z][a-z].+";
        String words[] = text.split(" ");
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.matches(namePattern)) {
                word = word.replaceAll("[a-z]", "*");
            }
            result += " " + word;
        }
        return result;
    }

}
