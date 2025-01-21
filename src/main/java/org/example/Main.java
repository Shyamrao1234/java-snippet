package org.example;

import javax.swing.*;

/**
 * Created by $CapName on Jan 20, 2025.
 */

public class Main {
    public static void main(String[] args) {
        String word1 = new String("Java");
        String word2 = new String("Java");

        System.out.println("  "+ word1 == word2); //false

        System.out.println(" "+word1.equals(word2));

        String word3="Java";
        String word4="Java";

        System.out.println(word3 == word4);


//        System.out.println("Hello, World!");
    }
}