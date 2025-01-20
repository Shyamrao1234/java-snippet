package org.example;

/**
 * Created by $CapName on Jan 20, 2025.
 */

public class Palindrome {
    public static void main(String[] args) {

        int r, sum = 0, temp;
        int n      = 454;

        temp = n;
        while (n > 0) {
            r = n % 10;
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum) {
            System.out.printf("palindrome");
        } else {
            System.out.printf("not palindrome");
        }

    }
}
