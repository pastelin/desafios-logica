package com.codewars.six;

public class MineFinder {

    public static int[] findMine(int[][] field){

        // Validate input
        if (field == null || field.length == 0 || field[0].length == 0) {
            throw new IllegalArgumentException("Field cannot be null or empty.");
        }

        // Iterate through the field to locate the mine
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    return new int[]{i, j}; // Return the location of the mine
                }
            }
        }

        // Return {-1, -1} if no mine is found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] field = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[] mineLocation = findMine(field);
        System.out.println("Mine found at: (" + mineLocation[0] + ", " + mineLocation[1] + ")");
    }
}
