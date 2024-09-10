package com.codewars.eight;

import java.util.stream.IntStream;

public class CountByX {

    public static int[] countBy(int x, int n) {

        int[] multiplesArray = new int[n];

        for(int i = 1; i <= n; i++) {
            multiplesArray[i-1] = x * i;
        }

        return multiplesArray;
    }

    public static int[] countBy2(int x, int n){

        return IntStream.rangeClosed(1, n)
                .map(i -> i * x)
                .toArray();
    }

}
