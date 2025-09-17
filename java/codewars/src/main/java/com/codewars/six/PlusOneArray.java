package com.codewars.six;

import java.util.Arrays;

public class PlusOneArray {

    public static int[] upArray(final int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        for (int digit : arr) {
            if (digit < 0 || digit > 9) {
                return null;
            }
        }

        int[] result = Arrays.copyOf(arr, arr.length);

        for (int i = result.length - 1; i >= 0; i--) {
            result[i]++;

            if (result[i] < 10) {
                return result;
            }

            result[i] = 0;
        }

        int[] newArray = new int[result.length + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        System.out.println(Arrays.toString(upArray(arr)));
    }
}
