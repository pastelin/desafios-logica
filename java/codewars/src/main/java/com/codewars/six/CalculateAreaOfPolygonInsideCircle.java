package com.codewars.six;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateAreaOfPolygonInsideCircle {

    /**
     * Calculates the area of a regular polygon inscribed in a circle.
     *
     * @param circleRadius   The radius of the circle.
     * @param numberOfSides  The number of sides of the polygon.
     * @return The area of the polygon rounded to 3 decimal places.
     */
    public static double areaOfPolygonInsideCircle(double circleRadius, int numberOfSides) {

        // Calculate the length of one side of the polygon
        double polygonSideLength = 2 * circleRadius * Math.sin(Math.PI / numberOfSides);

        // Calculate the area of the polygon using the formula
        // Area = (n * L^2) / (4 * tan(π/n))
        // where n is the number of sides and L is the length of one side
        BigDecimal polygonArea = BigDecimal.valueOf((numberOfSides * Math.pow(polygonSideLength, 2)) / (4 * Math.tan(Math.PI / numberOfSides)));

        return polygonArea.setScale(3, RoundingMode.HALF_DOWN).doubleValue();
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(areaOfPolygonInsideCircle(3, 3)); // Triángulo
        System.out.println(areaOfPolygonInsideCircle(5, 4)); // Cuadrado
        System.out.println(areaOfPolygonInsideCircle(5, 6)); // Hexágono
        System.out.println(areaOfPolygonInsideCircle(5, 8)); // Octágono
    }
}
