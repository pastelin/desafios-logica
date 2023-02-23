package com.codewars.eight.katas;

import java.util.stream.IntStream;

public class CountPositivesSumOfNegatives {

    public static int[] countPositivesSumNegatives(int[] input) {

        if((input == null || input.length == 0)) {
            return new int[0];
        }
        int countPositive = 0;
        int sumNegative = 0;

        for(int value : input) {
            if(value > 0) {
                countPositive++;
            } else {
                sumNegative += value;
            }
        }

        return new int[]{countPositive, sumNegative};
    }

    public static int[] countPositivesSumNegatives2(int[] input) {
        return input == null || input.length == 0 ?
                new int[0] :
                new int[] { (int) IntStream.of(input).filter(i->i>0).count(), IntStream.of(input).filter(i->i<0).sum() };
    }

}
