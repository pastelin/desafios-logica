package com.codewars.five;

import java.util.Arrays;

/*
* Create a function that returns an array containing the first l numbers from the nth diagonal of Pascal's triangle.
* n = 0 should generate the first diagonal of the triangle (the ones).
* The first number in each diagonal should be 1.
* If l = 0, return an empty array.
* Both n and l will be non-negative integers in all test cases.
* */
public class PascalsDiagonals {

    public static long[] generateDiagonal(int n, int l) {
        long[] result = new long[l];
        for (int i = 0; i < l; i++) {
            result[i] = factorial(n + i);
        }
        return result;
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateDiagonal(38, 14)));
    }
}
