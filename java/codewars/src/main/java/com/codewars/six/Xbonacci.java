package com.codewars.six;

import java.util.Arrays;

/**
 * Genera una secuencia tipo Fibonacci generalizada (Xbonacci).
 *
 * Concepto: En lugar de sumar solo los 2 últimos números (Fibonacci),
 * suma los últimos X números de una "firma" (patrón inicial).
 *
 * Definición:
 * - Fibonacci clásico: cada número es suma de los 2 anteriores
 *   1, 1, 2, 3, 5, 8, 13, 21, ...
 *
 * - Xbonacci: cada número es suma de los últimos N números de la firma
 *   signature = [1, 1, 2] → cada nuevo número suma los 3 anteriores
 *   resultado = [1, 1, 2, 4, 7, 13, 24, ...]
 *              1¹ + 1¹ + 2²
 *   donde 1¹ + 1¹ + 2² = 4
 *
 * Ejemplos:
 *   xbonacci([0,1], 5)     → [0, 1, 1, 2, 3]     (Fibonacci clásico)
 *   xbonacci([1,1,1], 5)   → [1, 1, 1, 3, 5]     (Tribonacci)
 *   xbonacci([1,0,0], 5)   → [1, 0, 0, 1, 1]
 *   xbonacci([0,1], 0)     → []                  (n=0)
 *   xbonacci([1,1], 1)     → [1]                 (n=1)
 *
 * @author Codewars Level 6
 */
public class Xbonacci {

    /**
     * Genera una secuencia Xbonacci de N elementos.
     *
     * Algoritmo:
     * 1. Crea un array de tamaño N con copia de la firma inicial
     * 2. Para cada posición i desde len hasta n-1:
     *    a. Suma los últimos len elementos (desde i-len hasta i-1)
     *    b. Asigna la suma a result[i]
     * 3. Retorna el array completo
     *
     * Ejemplo paso a paso con signature=[1,1,2], n=7:
     * Posición 0: signature[0] = 1
     * Posición 1: signature[1] = 1
     * Posición 2: signature[2] = 2
     * Posición 3: result[0] + result[1] + result[2] = 1 + 1 + 2 = 4
     * Posición 4: result[1] + result[2] + result[3] = 1 + 2 + 4 = 7
     * Posición 5: result[2] + result[3] + result[4] = 2 + 4 + 7 = 13
     * Posición 6: result[3] + result[4] + result[5] = 4 + 7 + 13 = 24
     * Resultado: [1, 1, 2, 4, 7, 13, 24]
     *
     * Casos especiales:
     * - Si n ≤ signature.length: retorna solo los primeros n elementos
     * - Si n = 0: retorna array vacío
     * - Si signature.length > n: los elementos no usados se ignoran
     *
     * Complejidad temporal: O(n * len) donde len = signature.length
     * Complejidad espacial: O(n) para el array resultado
     *
     * @param signature array de números iniciales (patrón Xbonacci)
     * @param n cantidad de números a generar
     * @return array con los primeros n números de la secuencia
     */
    public double[] xbonacci(double[] signature, int n) {

        // Copia la firma al resultado, limitado a n elementos
        double[] result = Arrays.copyOf(signature, n);
        int len = signature.length;

        // Genera los elementos restantes sumando los últimos len elementos
        for (int i = len; i < n; i++) {
            double sum = 0;
            // Suma los últimos len elementos
            for (int j = i - len; j < i; j++) {
                sum += result[j];
            }
            // Asigna la suma como nuevo elemento
            result[i] = sum;
        }

        return result;
    }
}
