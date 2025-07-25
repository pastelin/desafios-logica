package com.codewars.six;

import java.util.ArrayList;
import java.util.List;

public class PeacefulYard {

    /**
     * Determines if the yard is peaceful based on the minimum distance between cats.
     *
     * @param yard        Array of strings representing the yard.
     * @param minDistance Minimum distance required between cats.
     * @return True if the yard is peaceful, false otherwise.
     */
    public static boolean peacefulYard(String[] yard, int minDistance) {
        // Validate input
        if (yard == null || yard.length == 0 || minDistance < 0) {
            throw new IllegalArgumentException("Invalid input: yard cannot be null/empty and minDistance must be non-negative.");
        }

        // Get the positions of all cats in the yard
        List<int[]> catPositions = getCatPositions(yard);

        // Check the distance between all pairs of cats
        for (int i = 0; i < catPositions.size(); i++) {
            for (int j = i + 1; j < catPositions.size(); j++) {
                double distance = calculateDistance(catPositions.get(i), catPositions.get(j));
                if (distance < minDistance) {
                    return false; // If any pair of cats is too close, the yard is not peaceful
                }
            }
        }

        return true; // The yard is peaceful if all cats are far enough apart
    }

    /**
     * Extracts the positions of all cats (L, M, R) in the yard.
     *
     * @param yard Array of strings representing the yard.
     * @return List of integer arrays, where each array contains the row and column of a cat.
     */
    private static List<int[]> getCatPositions(String[] yard) {
        List<int[]> positions = new ArrayList<>();

        for (int row = 0; row < yard.length; row++) {
            String line = yard[row];
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == 'L' || line.charAt(col) == 'M' || line.charAt(col) == 'R') {
                    positions.add(new int[]{row, col}); // Store the position of the cat
                }
            }
        }

        return positions;
    }

    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param point1 Array containing the row and column of the first point.
     * @param point2 Array containing the row and column of the second point.
     * @return The Euclidean distance between the two points.
     */
    private static double calculateDistance(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }


    public static void main(String[] args) {
        String[] yard = {
                "------------",
                "------------",
                "-L----------",
                "------------",
                "------------",
                "------------"
        };
        int minDistance = 6;

        String[] yard1 = {
                "------------", "---M--------", "------------", "------------", "-------R----", "------------"
        };

        boolean result = peacefulYard(yard1, minDistance);
        System.out.println("Is the yard peaceful? " + result); // Debería imprimir true o false según el caso
    }
}
