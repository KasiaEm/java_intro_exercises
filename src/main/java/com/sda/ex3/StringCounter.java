package com.sda.ex3;

public class StringCounter {

    public static void main(String[] args) {
        String text = "abcdaaadfabfdeaababfdabeaaaa";

        System.out.println(countOccurences(text, 'a'));
        System.out.println(countOccurences(text, "ab"));

    }

    public static int countOccurences(String text, char c) {
        char letters[] = text.toCharArray();
        int max = 0;
        int count = 0;
        for (int i = 0 ; i<letters.length; i++) {
            char x = letters[i];
            if (x == c)
                count++;
            if (x != c || i==(letters.length-1)) {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max;
    }


    //TODO
    public static int countOccurences(String text, String s) {
        int max = 0;
        int tempCounter = 0;
        int i = 0;

        while(i<text.length()){
            if(i+s.length()>=text.length()){
                if (tempCounter > max) {
                    max = tempCounter;
                }
                break;
            }
            if(text.substring(i, i+s.length()).equals(s)){
                tempCounter++;
                i+=s.length();
            } else {
                if (tempCounter > max) {
                    max = tempCounter;
                }
                tempCounter = 0;
                i++;
            }
        }
        return max;
    }
}
