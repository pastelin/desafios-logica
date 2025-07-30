package com.codewars.six;

import java.util.*;

public class SqProd2Sum {
    public static List<long[]> prod2SumV2(long a, long b, long c, long d) {
        long sum = (long) ((Math.pow(a, 2) + Math.pow(b, 2)) * (Math.pow(c, 2) + Math.pow(d, 2)));

        List<long[]> result = new ArrayList<>();

        for (int i = 1; i <= sum; i++) {
            int sumI = (int) Math.pow(i, 2);
            if (sumI > sum) {
                break;
            }
            for (int j = 1; j <= sum; j++) {
                int sumJ = (int) Math.pow(j, 2);
                if (sumI + sumJ == sum) {
                    result.add(new long[]{i, j});
                    break;
                }

                if (sumJ > sum) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Calcula los pares de enteros (e, f) tales que (a^2 + b^2) * (c^2 + d^2) = e^2 + f^2.
     * Utiliza la Identidad de Brahmagupta-Fibonacci para encontrar las soluciones.
     * <p>
     * La identidad establece que:
     * (a^2 + b^2)(c^2 + d^2) = (ac - bd)^2 + (ad + bc)^2
     * Y también:
     * (a^2 + b^2)(c^2 + d^2) = (ac + bd)^2 + (ad - bc)^2
     *
     * @param a Primer entero (tipo long).
     * @param b Segundo entero (tipo long).
     * @param c Tercer entero (tipo long).
     * @param d Cuarto entero (tipo long).
     * @return Una lista de arreglos de tipo long (pares [e, f]), donde cada par está ordenado
     * (el elemento menor primero) y la lista de pares está ordenada por el primer elemento.
     * La lista no contendrá pares duplicados.
     */
    public static List<long[]> prod2sum(long a, long b, long c, long d) {
        // Usamos un TreeSet para almacenar los pares.
        // Un TreeSet automáticamente ordena los elementos y maneja la unicidad.
        // Necesitamos un Comparator personalizado para ordenar los arreglos long[]
        // Primero por el primer elemento, y si son iguales, por el segundo.
        // Compara por el primer elemento del par
        // Si el primer elemento es igual, compara por el segundo
        Set<long[]> solutions = new TreeSet<>(Comparator.comparingLong((long[] pair) -> pair[0]).thenComparingLong(pair -> pair[1]));

        // --- Primera solución basada en la identidad de Brahmagupta-Fibonacci ---
        // e1 = |ac - bd|
        // f1 = |ad + bc|
        long e1 = Math.abs(a * c - b * d); // Las operaciones ya son con long
        long f1 = Math.abs(a * d + b * c);

        // Aseguramos que el elemento menor esté primero en el par
        long[] pair1 = new long[]{Math.min(e1, f1), Math.max(e1, f1)};
        solutions.add(pair1); // Agregamos el par al TreeSet

        // --- Segunda solución basada en la identidad de Brahmagupta-Fibonacci ---
        // e2 = |ac + bd|
        // f2 = |ad - bc|
        long e2 = Math.abs(a * c + b * d);
        long f2 = Math.abs(a * d - b * c);

        // Aseguramos que el elemento menor esté primero en el par
        long[] pair2 = new long[]{Math.min(e2, f2), Math.max(e2, f2)};
        solutions.add(pair2); // Agregamos el segundo par al TreeSet

        // Convertimos el TreeSet (que ya está ordenado y sin duplicados) a un ArrayList
        // para cumplir con el tipo de retorno List<long[]>.
        return new ArrayList<>(solutions);
    }

    // --- Método principal para probar la función ---
    public static void main(String[] args) {
        // Helper para imprimir la lista de pares de forma legible
        // (no es parte de la solución del problema, solo para demostración)

        System.out.println("prod2sum(1, 2, 1, 3) => " + formatResult(prod2sum(1, 2, 1, 3)));
        System.out.println("prod2sum(1, 2, 1, 3) => " + formatResult(prod2SumV2(1, 2, 1, 3)));

        // Esperado: [[1, 7], [5, 5]]

        System.out.println("prod2sum(2, 3, 4, 5) => " + formatResult(prod2sum(2, 3, 4, 5)));
        // Esperado: [[2, 23], [7, 22]]

        System.out.println("prod2sum(1, 2, 2, 3) => " + formatResult(prod2sum(1, 2, 2, 3)));
        // Esperado: [[1, 8], [4, 7]]

        System.out.println("prod2sum(1, 1, 3, 5) => " + formatResult(prod2sum(1, 1, 3, 5)));
        // Esperado: [[2, 8]]
    }

    /**
     * Método auxiliar para formatear la salida de una lista de pares de tipo long[] a String
     * para una impresión legible en la consola.
     *
     * @param result La lista de pares de tipo long[] a formatear.
     * @return Una representación en String de la lista de pares.
     */
    private static String formatResult(List<long[]> result) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.size(); i++) {
            sb.append(Arrays.toString(result.get(i)));
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
