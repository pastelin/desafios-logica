package com.codewars.eight;

import java.util.stream.IntStream;

/**
 * Calcula la suma de los cuadrados de todos los números en un array.
 *
 * Objetivo: Procesar un array de enteros, elevar cada número al cuadrado,
 * y retornar la suma de todos los cuadrados.
 *
 * Ejemplos:
 *   [1, 2, 3]     → 1² + 2² + 3² = 1 + 4 + 9 = 14
 *   [2, 4, 5]     → 2² + 4² + 5² = 4 + 16 + 25 = 45
 *   [1]           → 1² = 1
 *   [0, 0, 0]     → 0 + 0 + 0 = 0
 *
 * @author Codewars Level 8
 */
public class SquareSum {

    /**
     * Retorna la suma de los cuadrados de los números en el array.
     *
     * Utiliza programación funcional con Streams:
     * 1. IntStream.of(numeros) crea un stream con los valores del array
     * 2. map(number -> number * number) eleva cada número al cuadrado
     * 3. sum() suma todos los cuadrados resultantes
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1)
     *
     * @param numeros array de enteros
     * @return la suma de los cuadrados de todos los números
     */
    public static int squareSum(int[] numeros) {
        return IntStream.of(numeros)
                .map(number -> number * number)
                .sum();
    }

}
