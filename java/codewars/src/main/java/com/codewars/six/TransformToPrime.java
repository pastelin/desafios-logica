package com.codewars.six;

// Given a list of positive integers, determine the minimum non-negative integer that needs to be inserted so that the sum of all elements becomes a prime number.
public class TransformToPrime {

    public static int minimumNumber(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        int i = 0;
        while (!isPrime(sum + i)) {
            i++;
        }
        return i;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        System.out.println(Math.sqrt(n));
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minimumNumber(new int[]{3, 1, 2}));
    }
}
