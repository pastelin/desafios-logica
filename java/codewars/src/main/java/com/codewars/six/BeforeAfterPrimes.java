package com.codewars.six;

public class BeforeAfterPrimes {

    /**
     * Finds the prime number immediately before and after the given number.
     * @param num The number to search around.
     * @return An array of two longs: [prime_before, prime_after].
     */
    public static long[] primeBefAft(long num) {
        long[] result = new long[2];

        // Search downwards for the prime before num
        for (long i = num - 1; i > 1; i--) {
            if (isPrime(i)) {
                result[0] = i;
                break;
            }
        }

        // Search upwards for the prime after num
        for (long i = num + 1; ; i++) {
            if (isPrime(i)) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    /**
     * A more optimized method to check if a number is prime.
     * @param n The number to check.
     * @return true if n is prime, false otherwise.
     */
    private static boolean isPrime(long n) {
        // Step 1: Handle base cases and even numbers.
        if (n <= 1) {
            return false; // 1 and negative numbers are not prime.
        }
        if (n == 2) {
            return true;  // 2 is the only even prime number.
        }
        if (n % 2 == 0) {
            return false; // All other even numbers are not prime.
        }

        // Step 2: Loop only through odd numbers.
        // If n is odd, it can only be divided by other odd numbers.
        // We start at 3 and increment by 2 (3, 5, 7, ...).
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false; // Found a divisor, so it's not prime.
            }
        }

        return true; // No divisors found, it's prime.
    }

}
