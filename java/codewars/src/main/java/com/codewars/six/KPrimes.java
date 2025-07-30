package com.codewars.six;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KPrimes {

    /**
     * Cuenta el número de factores primos de un número natural dado,
     * incluyendo su multiplicidad.
     * <p>
     * Ejemplos:
     * countPrimeFactors(12) -> factores primos: 2, 2, 3 (cuenta = 3)
     * countPrimeFactors(7)  -> factor primo: 7 (cuenta = 1)
     * countPrimeFactors(1)  -> 0 (1 no tiene factores primos según esta definición)
     * countPrimeFactors(0)  -> 0 (0 no es un número natural positivo y no tiene factores primos)
     *
     * @param n El número natural para el cual contar l4os factores primos.
     * @return El número de factores primos.
     */
    private static long countPrimeFactors(long n) {

        // Los números naturales en este contexto suelen ser enteros positivos (>= 1).
        // 0 y 1 no tienen factores primos.
        if (n <= 1) {
            return 0;
        }

        int count = 0;
        long tempN = n; // Usamos una variable temporal para evitar modificar el original

        // Paso 1: Contar los factores de 2
        // Dividimos por 2 hasta que tempN ya no sea divisible por 2.
        // Cada división incrementa la cuenta de factores primos.
        while (tempN % 2 == 0) {
            count++;
            tempN /= 2;
        }

        // Paso 2: Contar los factores impares
        // Iteramos a partir de 3, incrementando de 2 en 2 (solo números impares).
        // La iteración va hasta la raíz cuadrada de tempN, porque si tempN tuviera un
        // factor primo mayor que su raíz cuadrada, también debería tener uno menor
        // (que ya habríamos encontrado), o tempN mismo sería primo.
        for (int i = 3; (long) i * i <= tempN; i += 2) {
            while (tempN % i == 0) {
                count++;
                tempN /= i;
            }
        }

        // Paso 3: Si tempN es mayor que 2 después de los pasos anteriores,
        // significa que el valor restante de tempN es un factor primo en sí mismo.
        // Esto cubre casos donde el número original era primo, o su factor primo más grande
        // es mayor que su raíz cuadrada.
        if (tempN > 2) {
            count++;
        }

        return count;

    }


    /**
     * Encuentra pares de números k-primos dentro de un rango especificado (start, nd)
     * que están separados por un 'step' dado.
     *
     * @param k     El número deseado de factores primos para los números k-primos.
     * @param step  La diferencia ('step') entre los dos números k-primos en un par.
     * @param start El inicio inclusivo del rango de búsqueda.
     * @param nd    El final inclusivo del rango de búsqueda.
     * @return Una lista de arrays de enteros, donde cada array interno representa un par
     * [k-primo1, k-primo2]. Devuelve una lista vacía si no se encuentran dichos pares.
     */
    public static List<long[]> kprimesStep(int k, int step, long start, long nd) {

        // Lista para almacenar los pares de k-primos que cumplan la condición del step.
        List<long[]> result = new ArrayList<>();

        // Usamos un HashSet para una búsqueda eficiente de O(1) en tiempo promedio.
        // Esto es crucial para no tener una complejidad O(N^2) al buscar el segundo número del par.
        HashSet<Long> kPrimesSet = new HashSet<>();

        // También usamos una lista ordenada para mantener el orden de los k-primos
        // y asegurar que el primer elemento del par siempre sea menor.
        List<Long> kPrimesInRangeOrdered = new ArrayList<>();

        // Primera pasada: Identificar todos los números k-primos dentro del rango [start, nd]
        // y almacenarlos en la lista ordenada y en el HashSet.
        for (long i = start; i <= nd; i++) {
            if (countPrimeFactors(i) == k) {
                kPrimesInRangeOrdered.add(i);
                kPrimesSet.add(i); // Agregamos al set para búsquedas rápidas
            }
        }

        // Segunda pasada: Iterar a través de la lista ordenada de k-primos.
        // Para cada k-primo (num1), calculamos el posible segundo número (num2 = num1 + step).
        // Luego, verificamos si num2 existe en nuestro HashSet de k-primos y si está dentro del rango.
        for (long num1 : kPrimesInRangeOrdered) {
            long num2 = num1 + step;
            // Verificamos si num2 está dentro del rango de búsqueda y si es un k-primo
            // (ya está en kPrimesSet si lo es y cumple la condición de k).
            if (num2 <= nd && kPrimesSet.contains(num2)) {
                result.add(new long[]{num1, num2});
            }
        }

        return result;
    }

    // Método principal para probar la función con los ejemplos dados.
    public static void main(String[] args) {
        System.out.println("kprimesStep(2, 2, 0, 50) => " + listToString(KPrimes.kprimesStep(2, 2, 0L, 50L)));
        // Salida esperada: [[4, 6], [33, 35]]

        System.out.println("kprimesStep(6, 14, 2113665, 2113889) => " + listToString(KPrimes.kprimesStep(6, 14, 2113665, 2113889)));
        // Salida esperada: [[2113722, 2113736]]

        System.out.println("kprimesStep(2, 10, 0, 50) => " + listToString(KPrimes.kprimesStep(2, 10, 0, 50)));
        // Salida esperada: [[4, 14], [15, 25], [25, 35], [39, 49]]

        System.out.println("kprimesStep(5, 20, 0, 50) => " + listToString(KPrimes.kprimesStep(5, 20, 0, 50)));
        // Salida esperada: []
    }

    /**
     * Helper para convertir una List<int[]> a String para una impresión legible.
     * (No es parte de la solución principal del problema, solo para pruebas).
     */
    private static String listToString(List<long[]> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            long[] pair = list.get(i);
            sb.append("[").append(pair[0]).append(", ").append(pair[1]).append("]");
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
