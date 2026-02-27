package com.codewars.eight;

import java.util.stream.IntStream;

/**
 * Genera arrays de múltiplos consecutivos de un número X.
 *
 * Objetivo: Crear un array con los primeros N múltiplos de X.
 *
 * Ejemplo:
 *   countBy(2, 5) → [2, 4, 6, 8, 10]
 *   countBy(3, 4) → [3, 6, 9, 12]
 *
 * @author Codewars Level 8
 */
public class CountByX {

    /**
     * Retorna un array con los N primeros múltiplos de X (enfoque iterativo).
     *
     * Algoritmo:
     * - Crea un array de tamaño N
     * - Itera desde 1 hasta N (inclusive)
     * - En cada posición i-1, almacena x * i
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(n)
     *
     * @param x el número base
     * @param n la cantidad de múltiplos a generar
     * @return array con los N primeros múltiplos de X
     */
    public static int[] countBy(int x, int n) {

        int[] multiplesArray = new int[n];

        for(int i = 1; i <= n; i++) {
            multiplesArray[i-1] = x * i;
        }

        return multiplesArray;
    }

    /**
     * Retorna un array con los N primeros múltiplos de X (enfoque funcional).
     *
     * Utiliza Streams de Java 8+:
     * - IntStream.rangeClosed(1, n) genera números del 1 al n
     * - map(i -> i * x) transforma cada número en su múltiplo
     * - toArray() convierte el resultado en un array int[]
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(n)
     *
     * @param x el número base
     * @param n la cantidad de múltiplos a generar
     * @return array con los N primeros múltiplos de X
     */
    public static int[] countBy2(int x, int n){

        return IntStream.rangeClosed(1, n)
                .map(i -> i * x)
                .toArray();
    }

}
