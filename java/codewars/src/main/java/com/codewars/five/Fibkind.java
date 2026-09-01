package com.codewars.five;

import java.util.ArrayList;

/**
 * Fibkind: Clase que implementa operaciones sobre la secuencia de Fibonacci modificada.
 * 
 * <p>Esta clase resuelve el desafío de CodeWars que define una variante de Fibonacci donde:
 * - Los primeros dos elementos son siempre 1 y 1.
 * - Cada siguiente elemento se calcula usando índices dinámicos basados en valores anteriores.
 * 
 * <p><b>Fórmula especial:</b><br>
 * {@code fib[i] = fib[i - fib[i-1]] + fib[i - fib[i-2]]}
 * <br>
 * Lo peculiar: usamos valores como índices (no posiciones simples).
 * 
 * <p><b>Ejemplo de generación (primeros 8 elementos):</b><br>
 * {@code
 * fib[0] = 1
 * fib[1] = 1
 * fib[2] = fib[2-fib[1]] + fib[2-fib[0]] = fib[1] + fib[1] = 1 + 1 = 2
 * fib[3] = fib[3-fib[2]] + fib[3-fib[1]] = fib[1] + fib[2] = 1 + 2 = 3
 * fib[4] = fib[4-fib[3]] + fib[4-fib[2]] = fib[1] + fib[2] = 1 + 2 = 3
 * ...
 * }
 * 
 * @author Senior Developer
 * @version 1.0
 */
public class Fibkind {

    /**
     * Genera la secuencia de Fibonacci modificada con n elementos.
     * 
     * <p><b>Algoritmo:</b>
     * <ol>
     *   <li>Inicializa con [1, 1] (base necesaria)</li>
     *   <li>Itera desde índice 2 hasta n-1</li>
     *   <li>Para cada posición i, calcula: fib[i - fib[i-1]] + fib[i - fib[i-2]]</li>
     * </ol>
     * 
     * <p><b>Complejidad:</b>
     * <ul>
     *   <li>Temporal: O(n) - un solo recorrido lineal</li>
     *   <li>Espacial: O(n) - almacena n elementos en el ArrayList</li>
     * </ul>
     * 
     * <p><b>Casos borde:</b>
     * <ul>
     *   <li>n ≤ 2: Devuelve solo los elementos iniciales [1, 1] (sin llegar a generar más)</li>
     *   <li>n muy grande: Cuidado con overflow de Integer (considera usar Long si es necesario)</li>
     * </ul>
     * 
     * @param n número de elementos a generar en la secuencia
     * @return ArrayList con los primeros n elementos de la secuencia Fibkind
     * 
     * @example
     *   generarSecuencia(5) retorna [1, 1, 2, 3, 3]
     */
    private static ArrayList<Integer> generarSecuencia(int n) {
        ArrayList<Integer> fib = new ArrayList<>();
        
        // Inicializa con los dos primeros elementos: siempre 1, 1
        fib.add(1);
        fib.add(1);

        // Genera elementos desde índice 2 hasta n-1
        for (int i = 2; i < n; i++) {
            // Calcula: fib[i] = fib[i - fib[i-1]] + fib[i - fib[i-2]]
            // Nota: fib[i-1] y fib[i-2] son VALORES usados como índices
            int valueAtI1 = fib.get(i - 1); // Valor en posición i-1
            int valueAtI2 = fib.get(i - 2); // Valor en posición i-2
            
            int nextElement = fib.get(i - valueAtI1) + fib.get(i - valueAtI2);
            fib.add(nextElement);
        }

        return fib;
    }

    /**
     * Cuenta cuántos elementos de la secuencia Fibkind son >= k.
     * 
     * <p><b>Objetivo:</b> Determinar cuántos componentes superan un umbral específico.
     * 
     * <p><b>Algoritmo:</b>
     * <ol>
     *   <li>Genera la secuencia de n elementos</li>
     *   <li>Recorre cada elemento</li>
     *   <li>Incrementa contador si el elemento >= k</li>
     * </ol>
     * 
     * <p><b>Complejidad:</b>
     * <ul>
     *   <li>Temporal: O(n) - generación O(n) + iteración O(n) = O(n)</li>
     *   <li>Espacial: O(n) - por el ArrayList interno</li>
     * </ul>
     * 
     * @param n tamaño de la secuencia a generar
     * @param k umbral de comparación (inclusive: valor >= k cuenta)
     * @return número total de elementos que cumplen value >= k
     * 
     * @example
     *   lengthSupUK(5, 2) con secuencia [1, 1, 2, 3, 3]
     *   Elementos >= 2: [2, 3, 3] → retorna 3
     */
    public static long lengthSupUK(int n, int k) {
        // Genera la secuencia de n elementos
        ArrayList<Integer> fib = generarSecuencia(n);

        long count = 0L; // Usa long para soportar conteos grandes

        // Itera sobre cada elemento de la secuencia
        for (int value : fib) {
            // Incrementa contador si el elemento supera el umbral k
            if (value >= k) {
                count++;
            }
        }

        return count;
    }

    /**
     * Cuenta cuántas veces la secuencia Fibkind decrece (elemento < anterior).
     * 
     * <p><b>Objetivo:</b> Medir la "inestabilidad" o "bajadas" en la secuencia.
     * En una secuencia típica de Fibonacci siempre crece, pero esta variación puede decrecer.
     * 
     * <p><b>Algoritmo:</b>
     * <ol>
     *   <li>Genera la secuencia de n elementos</li>
     *   <li>Compara cada elemento con su predecesor (i con i-1)</li>
     *   <li>Incrementa contador si fib[i] < fib[i-1] (hay decrecimiento)</li>
     * </ol>
     * 
     * <p><b>Complejidad:</b>
     * <ul>
     *   <li>Temporal: O(n) - recorre n-1 comparaciones</li>
     *   <li>Espacial: O(n) - por el ArrayList interno</li>
     * </ul>
     * 
     * <p><b>Comportamiento esperado:</b>
     * Esta secuencia sí presenta decrementos ocasionales, a diferencia de Fibonacci clásico.
     * 
     * @param n tamaño de la secuencia a generar
     * @return número de posiciones donde fib[i] < fib[i-1]
     * 
     * @example
     *   comp(5) con secuencia [1, 1, 2, 3, 3]
     *   Comparaciones: 1<1? No, 2<1? No, 3<2? No, 3<3? No
     *   retorna 0 (esta secuencia no decrece en este rango)
     */
    public static long comp(int n) {
        // Genera la secuencia de n elementos
        ArrayList<Integer> fib = generarSecuencia(n);

        long count = 0L; // Usa long para soportar conteos grandes

        // Itera desde índice 1 (segunda posición) hasta n-1
        for (int i = 1; i < n; i++) {
            // Compara elemento actual con su predecesor
            if (fib.get(i) < fib.get(i - 1)) {
                // Se encontró un decrecimiento
                count++;
            }
        }

        return count;
    }
}
