package com.codewars.eight.katas;

import java.util.stream.IntStream;

public class SquareSum {

    public static int squareSum(int[] numeros) {
        return IntStream.of(numeros).map(number -> number * number).sum();
    }

}
