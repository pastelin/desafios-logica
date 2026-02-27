package com.codewars.eight;

import java.util.stream.IntStream;

/**
 * Cuenta números positivos y suma números negativos en un array.
 *
 * Objetivo: Procesar un array de enteros para:
 * 1. Contar cuántos números son positivos (> 0)
 * 2. Sumar todos los números negativos (< 0)
 *
 * Ejemplos:
 *   [1, 2, 3, 4, 5]        → [5, 0]       (5 positivos, sin negativos)
 *   [0, -1, -2, -3, -4]    → [0, -10]     (sin positivos, suma = -10)
 *   [1, 2, 0, -1, -2]      → [2, -3]      (2 positivos, suma = -3)
 *   null o []              → []           (entrada inválida)
 *
 * @author Codewars Level 8
 */
public class CountPositivesSumOfNegatives {

    /**
     * Cuenta positivos y suma negativos (enfoque iterativo).
     *
     * Algoritmo:
     * 1. Valida entrada (null o vacía retorna array vacío)
     * 2. Itera sobre cada valor del array
     * 3. Si es positivo (> 0): incrementa contador
     * 4. Si no es positivo: suma al acumulador de negativos
     * 5. Retorna array [countPositivos, sumaNegativos]
     *
     * Nota: El 0 no se cuenta como positivo ni se suma como negativo
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1) para variables, O(1) para salida
     *
     * @param input array de enteros (puede ser null)
     * @return array con [cantidad_positivos, suma_negativos], o [] si entrada inválida
     */
    public static int[] countPositivesSumNegatives(int[] input) {

        // Valida la entrada
        if((input == null || input.length == 0)) {
            return new int[0];
        }

        int countPositive = 0;
        int sumNegative = 0;

        // Itera sobre cada valor
        for(int value : input) {
            if(value > 0) {
                countPositive++;
            } else {
                // Suma valores negativos (incluyendo 0 si no es positivo)
                sumNegative += value;
            }
        }

        return new int[]{countPositive, sumNegative};
    }

    /**
     * Cuenta positivos y suma negativos (enfoque funcional con Streams).
     *
     * Utiliza operaciones de stream:
     * - IntStream.of(input): crea stream de los valores
     * - filter(i -> i > 0).count(): cuenta positivos
     * - filter(i -> i < 0).sum(): suma negativos
     *
     * Nota: Se evalúa el array dos veces, eficiencia similar a la versión iterativa
     * pero con código más compacto y funcional.
     *
     * Complejidad temporal: O(2n) = O(n)
     * Complejidad espacial: O(1)
     *
     * @param input array de enteros (puede ser null)
     * @return array con [cantidad_positivos, suma_negativos], o [] si entrada inválida
     */
    public static int[] countPositivesSumNegatives2(int[] input) {
        return input == null || input.length == 0 ?
                new int[0] :
                new int[] {
                    (int) IntStream.of(input).filter(i -> i > 0).count(),
                    IntStream.of(input).filter(i -> i < 0).sum()
                };
    }

}
