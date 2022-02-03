package com.sda.ex15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    private static String text = "<div><p> This is number +48 243 543 646. </div> <div> <h1>Lalala</h1> abcdef 234-56-45.</div> <div>Michael's email: m.smith@gmail.com. <br> Clarice - mail clarice@o2.pl </div> Contact: 32 456 23 43.";
    private static Pattern pMail = Pattern.compile("[a-z\\.]+@([a-z0-9]+\\.[a-z]+)");
    private static Pattern pTags = Pattern.compile("</?([a-z0-9]+)>");

    public static void main(String[] args) {
        //findNumbers(text);
        //findTagsInside(text);
        replaceTagWith(text, "[TAG]");
    }

    public static void findNumbers(String text) {
        Matcher m = pMail.matcher(text);
        while (m.find()){
            System.out.println(m.group(0));
        }
    }

    public static void findTagsInside(String text) {
        Matcher m = pTags.matcher(text);
        while (m.find()){
            System.out.println(m.group(1));
        }
    }

    public static void replaceTagWith(String text, String tagName) {
        Matcher m = pTags.matcher(text);

        System.out.println(m.replaceAll(tagName));
    }
}
