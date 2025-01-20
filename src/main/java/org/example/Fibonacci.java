package org.example;

/**
 * Created by $CapName on Jan 20, 2025.
 */

public class Fibonacci {
    public static void main(String[] args) {

        int n1 = 0, n2 = 1, n3, i, count = 10;
        for (i = 2; i < count; i++) {
            n3 = n1 + n2;
            System.out.println("" + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}


//other way of writing fibonacci
class Fibonacci2 {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int count = 10, i;
        for (i = 0; i <= count; i++) {
            System.out.println("" + fibonacci(i));
        }
    }
}
