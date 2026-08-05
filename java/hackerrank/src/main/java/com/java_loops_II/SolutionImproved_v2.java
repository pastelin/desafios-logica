package com.java_loops_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Calcula series con potencias de 2.
 * Versión refactorizada con separación de responsabilidades.
 */
public class SolutionImproved_v2 {

    private static final class SeriesCalculator {
        /**
         * Calcula la serie: a + b*2^0 + b*2^1 + b*2^2 ... b*2^(n-1)
         */
        static List<Long> calculateSeries(long initial, long multiplier, int terms) {
            List<Long> results = new ArrayList<>(terms);
            long sum = initial;
            
            for (int i = 0; i < terms; i++) {
                sum += multiplier * (1L << i);
                results.add(sum);
            }
            
            return results;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            
            for (int i = 0; i < testCases; i++) {
                long a = scanner.nextLong();
                long b = scanner.nextLong();
                int n = scanner.nextInt();
                
                List<Long> series = SeriesCalculator.calculateSeries(a, b, n);
                printSeries(series);
            }
        } catch (Exception e) {
            System.err.println("Error al procesar entrada: " + e.getMessage());
        }
    }

    private static void printSeries(List<Long> series) {
        for (int i = 0; i < series.size(); i++) {
            System.out.print(series.get(i));
            if (i < series.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

