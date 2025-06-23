package com.codewars.six;

import java.util.*;
import java.util.stream.Collectors;

public class BunchCommonElementsSolution {

    static List<Integer> findCommonElements(int[] arrA, int[] arrB, int[] rng, String wanted) {
        List<Integer> listA = new ArrayList<>(Arrays.stream(arrA).boxed().collect(Collectors.toList()));
        List<Integer> listB = new ArrayList<>(Arrays.stream(arrB).boxed().collect(Collectors.toList()));
        Set<Integer> presentInBoth = new HashSet<>(listA);
        presentInBoth.retainAll(new HashSet<>(listB));

        Set<Integer> filteredPresentInBoth = presentInBoth.stream()
                .mapToInt(Integer::intValue)
                .filter(el -> el >= rng[0] && el <= rng[1])
                // Workaround for https://www.codewars.com/kata/58161c5ac7e37d17fc00002f/discuss#67dc7f8c2cc9dcbf1d5937aa
                .filter(el -> wanted.equals("even") ? (el % 2 == 0) : el % 2 != 0 && el >= 0)
                .boxed()
                .collect(Collectors.toSet());

        listA.retainAll(filteredPresentInBoth);
        listB.retainAll(filteredPresentInBoth);

        return filteredPresentInBoth.stream()
                .filter(el -> Collections.frequency(listA, el) > 1)
                .filter(el -> Collections.frequency(listB, el) > 1)
                .sorted()
                .collect(Collectors.toList());
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
