package com.codewars.six;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BunchCommonElements {

    static List<Integer> findCommonElements(int[] arrA, int[] arrB, int[] rng, String wanted) {

        List<Integer> listA = Arrays.stream(arrA).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(arrB).boxed().collect(Collectors.toList());

        listA.sort(Integer::compareTo);
        listB.sort(Integer::compareTo);

        List<Integer> commontElementsA = listA.stream().filter(i -> i >= rng[0] && i <= rng[1])
                .filter(listB::contains)
                .collect(Collectors.toList());


        for (int i = 0; i < commontElementsA.size(); i++) {
            int count = 0;
            for (int j = 1; j < commontElementsA.size(); j++) {

                if (commontElementsA.get(i).equals(commontElementsA.get(j))) {
                    count++;
                }
            }
            if (count == 0) {
                commontElementsA.remove(commontElementsA.get(i));
            }
        }

        commontElementsA = commontElementsA.stream().distinct().collect(Collectors.toList());

        List<Integer> commontElementsB = listB.stream().filter(i -> i >= rng[0] && i <= rng[1])
                .filter(commontElementsA::contains)
                .collect(Collectors.toList());


        for (int i = 0; i < commontElementsB.size(); i++) {
            int count = 0;
            for (int j = 1; j < commontElementsB.size(); j++) {

                if (commontElementsB.get(i).equals(commontElementsB.get(j))) {
                    count++;
                }
            }
            if (count == 0) {
                commontElementsB.remove(commontElementsB.get(i));
            }
        }

        return commontElementsB.stream().distinct().filter(i -> wanted.equals("odd") ? i % 2 != 0 : i % 2 == 0).collect(Collectors.toList());
    }


    public static void main(String[] args) {
//        System.out.println(findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 7, 1, 0, 2, 3}, new int[]{2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0}, new int[]{-4, 4}, "odd"));

//        System.out.println(findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 4, 7, 1, 0, 2, 3, 0, 4}, new int[]{0, 4, 2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0, 4}, new int[]{-4, 4}, "even").toString());
//        System.out.println(findCommonElements(new int[]{1, -2, 7, 2, 1, 3, 7, 1, 0, 2, 3}, new int[]{2, -1, 1, 1, 1, 1, 2, 3, 3, 7, 7, 0}, new int[]{-4, 4}, "odd").toString());

    }

}

