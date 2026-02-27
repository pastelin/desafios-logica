package com.codewars.six;

import java.util.Arrays;

public class Xbonacci {

    public double[] xbonacci(double[] signature, int n) {

        double[] result = Arrays.copyOf(signature, n);
        int len = signature.length;

        for (int i = len; i < n; i++) {
            double sum = 0;
            for (int j = i - len; j < i; j++) {
                sum += result[j];
            }
            result[i] = sum;
        }

        return result;
    }
}
