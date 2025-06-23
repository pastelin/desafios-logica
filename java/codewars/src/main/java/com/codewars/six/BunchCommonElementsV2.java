package com.codewars.six;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BunchCommonElementsV2 {

    /*
     * We are given two arrays of integers A and B and we have to output a sorted array with the integers that fulfill the following constraints:

     * they are present in both ones

     * they occur more than once in A and more than once in B

     * their values are within a given range (inclusive)

     * they are odd or even according as it is requested
     *
     * Example
     * Given two arrays, a range, and a wanted parity:
     *
     * arrA = [1, -2, 7, 2, 1, 3, 7, 1, 0, 2, 3]
     * arrB = [2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0]
     * rng = [-4, 4] # is the range of the integers from -4 to 4 (inclusive)
     * wanted = "odd"
     * Process to obtain the result:
     * 0, 1, 2, 3, 7, are the numbers present in arrA and arrB
     * 1, 2, 3, 7,  occur twice or more in arrA and arrB
     * 1, 2, 3,  are in the range [-4, 4]
     * 1, 3, are odd
     * output = [1, 3]
     * */
    static List<Integer> findCommonElements(int[] arrA, int[] arrB, int[] rng, String wanted) {
        // Convertir los arreglos en listas de Integer
        List<Integer> listA = Arrays.stream(arrA).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(arrB).boxed().collect(Collectors.toList());

        // Contar la frecuencia de cada elemento en ambas listas
        Map<Integer, Long> freqA = listA.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> freqB = listB.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Filtrar los elementos que están presentes en ambas listas y que ocurren más de una vez en cada una
        List<Integer> commonElements = freqA.entrySet().stream()
                .filter(e -> e.getValue() > 1 && freqB.getOrDefault(e.getKey(), 0L) > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Filtrar los elementos que están dentro del rango dado
        commonElements = commonElements.stream()
                .filter(e -> e >= rng[0] && e <= rng[1])
                .collect(Collectors.toList());

        // Filtrar los elementos según la paridad solicitada
        commonElements = commonElements.stream()
                .filter(e -> "odd".equals(wanted) ? e % 2 != 0 : e % 2 == 0)
                .collect(Collectors.toList());

        // Ordenar y devolver la lista resultante
        return commonElements.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arrA = {1, -2, 7, 2, 1, 3, 7, 1, 0, 2, 3};
        int[] arrB = {2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0};
        int[] rng = {-4, 4};
        String wanted = "odd";

        List<Integer> result = findCommonElements(arrA, arrB, rng, wanted);
        System.out.println(result); // Output: [1, 3]
    }

}
