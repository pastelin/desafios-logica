package com.codewars.six;

import java.util.Arrays;

public class WaveSorter {

    public static void waveSort(int[] array) {
        Arrays.sort(array);
        Arrays.asList(array).forEach(System.out::println);
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 34, 4, 5, 5, 5, 65, 6, 65, 5454, 4};
        System.out.println("Array original: " + Arrays.toString(array));
        waveSort(array);
        System.out.println("Array ordenado: " + Arrays.toString(array));
    }
}
