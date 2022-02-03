package com.sda.ex15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String text = "<div><p> This is number +48 243 543 646. </div> <div> <h1>Lalala</h1> abcdef 234-56-45.</div> <div>Michael's email: m.smith@gmail.com. <br> Clarice - mail clarice@o2.pl </div> Contact: 32 456 23 43.";
    private static Pattern pMail = Pattern.compile("[a-z0-9\\.]+@([a-z0-9]+\\.[a-z]{2,3})");
    private static Pattern pTags = Pattern.compile("</?([a-z0-9]+)>");

    public static void main(String[] args) {
        showTags();
    }

    static void showMail(){
        Matcher mMail = pMail.matcher(text);
        while (mMail.find()){
            System.out.println(mMail.group(0));
        }
    }

    static void showTags(){
        Matcher mTags = pTags.matcher(text);
        while (mTags.find()){
            System.out.println(mTags.group(1));
        }
    }
}
