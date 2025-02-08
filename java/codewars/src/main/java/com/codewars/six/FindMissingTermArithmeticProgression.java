package com.codewars.six;

/*
* An Arithmetic Progression is defined as one in which there is a constant difference between the consecutive terms of a given series of numbers.
* You are provided with consecutive elements of an Arithmetic Progression.
* There is however one hitch: exactly one term from the original series is missing from the set of numbers which have been given to you.
* The rest of the given series is the same as the original AP. Find the missing term.
*
* You have to write a function that receives a list, list size will always be at least 3 numbers.
* The missing term will never be the first or last one.
*
* */
public class FindMissingTermArithmeticProgression {

    /*
    * The findMissing method is designed to identify the missing term in an arithmetic progression (AP) numbers.
    * The method takes an array of integers, numbers, as its parameter.
    * The array represents the given terms of the AP with one term missing.
     * */
    public static int findMissing(int[] numbers) {
        /*
        * First, the method calculates the common difference (diff) of the AP.
        * This is done by subtracting the first element from the last element of the array and then dividing by the length of the array:
        * */
        int diff = (numbers[numbers.length - 1] - numbers[0]) / numbers.length;

        /*
        * Next, the method iterates through the array to find the missing term.
        * It uses a for loop to compare the difference between consecutive elements with the calculated diff:
        * */
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] != diff) {
                return numbers[i] + diff;
            }
        }

        /*
        * If the difference between any two consecutive elements does not match diff,
        * it means the missing term is between these two elements.
        * The method then returns the expected value of the missing term by adding diff to the current element.
        * If the loop completes without finding any discrepancy, the method returns the first element of the array as a default value,
        * although this case should not occur given the problem constraints:
        * */
        return numbers[0];
    }

    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{1, 3, 5, 9, 11})); // 7
        System.out.println(findMissing(new int[]{1, 3, 4})); // 2
        System.out.println(findMissing(new int[]{1, 2, 3, 4, 6, 7, 8, 9})); // 5
        System.out.println(findMissing(new int[]{1, 1, 1})); // 1
    }

}
