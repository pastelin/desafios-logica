package com.codewars.six;

public class Dinglemouse2 {

    /**
     * Calculates the perpendicular distance of point C from the line defined by points A and B.
     *
     * @param a The coordinates of point A as an array [x, y].
     * @param b The coordinates of point B as an array [x, y].
     * @param c The coordinates of point C as an array [x, y].
     * @return The perpendicular distance of point C from the line AB.
     * @throws IllegalArgumentException if any of the points are invalid.
     */
    public static double distanceFromLine(final int[] a, final int[] b, final int[] c) {
        // If points A and B are the same, return the distance from A to C
        if (a[0] == b[0] && a[1] == b[1]) {
            return calculateDistance(a, c);
        }

        // Calculate the area of the triangle formed by A, B, and C (absolute value to avoid negatives)
        double area = Math.abs(0.5 * (a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])));

        // Return the perpendicular distance using the formula: (2 * area) / base
        return (2 * area) / calculateDistance(a, b);
    }

    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param a The coordinates of the first point as an array [x, y].
     * @param b The coordinates of the second point as an array [x, y].
     * @return The Euclidean distance between the two points.
     */
    public static double calculateDistance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static void main(String[] args) {
        int[] a = {28, 83};
        int[] b = {8, 52};
        int[] c = {21, 78};

        double distance = distanceFromLine(a, b, c);
        System.out.println("Distance from line: " + distance); // Expected output: 1.0
    }

}
