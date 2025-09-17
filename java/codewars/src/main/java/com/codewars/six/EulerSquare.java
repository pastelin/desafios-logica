package com.codewars.six;

public class EulerSquare {

    /**
     * Creates a 3D array representing an Euler square of size n.
     * The first layer contains values calculated as (i + j) % n + 1.
     * The second layer contains values calculated as (i + 2 * j) % n + 1.
     *
     * @param n The size of the Euler square.
     * @return A 3D array representing the Euler square.
     */
    public static int[][][] createEulerSquare(int n) {
        // Initialize a 3D array with 2 layers, each of size n x n
        int[][][] result = new int[2][n][n];

        // Populate the 3D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // First layer: (i + j) % n + 1
                result[0][i][j] = (i + j) % n + 1;

                // Second layer: (i + 2 * j) % n + 1
                result[1][i][j] = (i + 2 * j) % n + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create an Euler square of size 5
        int[][][] eulerSquare = createEulerSquare(5);

        // Print the 3D array layer by layer
        for (int layer = 0; layer < eulerSquare.length; layer++) {
            System.out.println("Layer " + (layer + 1) + ":");
            for (int row = 0; row < eulerSquare[layer].length; row++) {
                for (int col = 0; col < eulerSquare[layer][row].length; col++) {
                    System.out.print(eulerSquare[layer][row][col] + " ");
                }
                System.out.println(); // Newline after each row
            }
            System.out.println(); // Newline after each layer
        }
    }

}
