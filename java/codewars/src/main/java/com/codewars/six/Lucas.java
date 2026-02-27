package com.codewars.six;

public class Lucas {
    public static int lucasnum(int n) {

        if (n == 0) {
            return 2;
        }

        if (n == 1) {
            return 1;
        }

        long a = 2;
        long b = 1;
        long current = 0;

        if (n >= 0) {
            for (int i = 2; i <= n; i++) {
                current = a + b;
                a = b;
                b = current;
            }
        } else {
            for (int i = 0; i > n; i--) {
                current = b - a;
                b = a;
                a = current;
            }
        }

        return (int) current;

    }

}
