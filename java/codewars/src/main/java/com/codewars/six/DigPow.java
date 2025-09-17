package com.codewars.six;

import java.util.ArrayList;
import java.util.List;

public class DigPow {

    /**
     * Calculates if a number `n` can be expressed as the sum of its digits raised to consecutive powers starting from `p`.
     * If valid, returns the multiplier `k` such that `n * k = sum`. Otherwise, returns -1.
     *
     * @param n The number to evaluate.
     * @param p The starting power for the digits.
     * @return The multiplier `k` if valid, otherwise -1.
     */
    public static long digPow(int n, int p) {
        // Initialize the sum of powered digits
        int sum = 0;

        // Extract digits from the number and store them in reverse order
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            digits.add(0, temp % 10); // Add digits in correct order
            temp /= 10;
        }

        // Calculate the sum of digits raised to consecutive powers
        for (int digit : digits) {
            sum += Math.pow(digit, p);
            p++;
        }

        // Check if the sum is divisible by the original number
        return (sum % n == 0) ? sum / n : -1;
    }

    public static void main(String[] args) {
        int n = 89;
        int p = 1;
        long result = digPow(n, p);
        if (result != -1) {
            System.out.println("The number " + n + " is a valid power number with k = " + result);
        } else {
            System.out.println("The number " + n + " is not a valid power number.");
        }
    }
}
