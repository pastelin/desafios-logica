package com.java_loops_II;

import java.util.Scanner;

/**
 * Calcula series de sumas usando potencias de 2.
 * Versión mejorada con cambios mínimos.
 */
public class SolutionImproved_v1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            
            for (int i = 0; i < t; i++) {
                long a = in.nextLong();
                long b = in.nextLong();
                int n = in.nextInt();

                long sum = a;
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    sum += (1L << j) * b;  // Bit shift en lugar de Math.pow
                    result.append(sum).append(" ");
                }
                
                System.out.println(result.toString().trim());
            }
        }
    }
}

