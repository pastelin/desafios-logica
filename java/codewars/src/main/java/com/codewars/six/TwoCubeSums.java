package com.codewars.six;

public class TwoCubeSums {

    // Create a function which checks if a given number n can be written as the sum of two cubes in two different ways, and if have 3 different ways must return false:
    //n=a3+b3=c3+d3
    //All the numbers a, b, c and d should be different and greater than 0.
    //
    //Example
    public static boolean hasTwoCubeSums(int n) {
        for (int a = 1; a <= Math.cbrt(n); a++) {
            for (int b = a; b <= Math.cbrt(n); b++) {
                if (((a * a * a) + (b * b * b)) == n) {
                    for (int c = a + 1; c <= Math.cbrt(n); c++) {
                        for (int d = c; d <= Math.cbrt(n); d++) {
                            if (c * c * c + d * d * d == n) {
                                return hasThreeCubeSums(n, a, b, c, d);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasThreeCubeSums(int n, int a, int b, int c, int d) {
        for (int e = c + 1; e <= Math.cbrt(n); e++) {
            for (int f = e; f <= Math.cbrt(n); f++) {
                if (e * e * e + f * f * f == n) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasTwoCubeSums(87539319));
    }
}
