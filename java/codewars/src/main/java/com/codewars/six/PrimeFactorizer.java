package com.codewars.six;

import java.util.HashMap;
import java.util.Map;

/**
 * Factoriza números en sus componentes primos.
 *
 * Objetivo: Descomponer un número en sus factores primos únicos y sus multiplicidades.
 *
 * Definición: La factorización prima expresa un número como producto de números primos.
 * Cada número tiene una factorización prima única (excepto por el orden).
 *
 * Ejemplos:
 *   - 24 = 2³ × 3¹  → {2: 3, 3: 1}
 *   - 30 = 2¹ × 3¹ × 5¹ → {2: 1, 3: 1, 5: 1}
 *   - 100 = 2² × 5² → {2: 2, 5: 2}
 *   - 13 = 13¹ → {13: 1} (número primo)
 *
 * @author Codewars Level 6
 */
public class PrimeFactorizer {

    /**
     * Calcula los factores primos de un número dado y sus multiplicidades.
     *
     * Algoritmo (Trial Division - División por Prueba):
     * 1. Comienza con el divisor más pequeño, 2
     * 2. Mientras el divisor² ≤ n:
     *    a. Si n es divisible por el divisor:
     *       - Incrementa el contador del factor
     *       - Divide n por el divisor
     *    b. Si no es divisible:
     *       - Pasa al siguiente divisor
     * 3. Si después del loop queda n > 1:
     *    - Ese número restante es primo y se agrega
     *
     * Optimización: Solo verificamos hasta √n porque si n tiene un factor > √n,
     * también debe tener un factor < √n que ya habría sido procesado.
     *
     * Ejemplos paso a paso:
     *   factor(24):
     *   - 24 ÷ 2 = 12 → {2: 1}
     *   - 12 ÷ 2 = 6  → {2: 2}
     *   - 6 ÷ 2 = 3   → {2: 3}
     *   - 3 no es divisible por 2
     *   - 3 no es divisible por 3 desde dentro del loop (3² > 3)
     *   - queda n=3, se agrega → {2: 3, 3: 1}
     *
     * Complejidad temporal: O(√n) en el mejor caso, O(√n) promedio
     * Complejidad espacial: O(log n) para almacenar los factores
     *
     * @param n El número long positivo a factorizar
     * @return Un Map donde las claves son los factores primos y los valores
     *         son sus multiplicidades (cuántas veces aparecen)
     */
    public java.util.Map<Long, Integer> factor(long n) {
        // Usamos un HashMap para almacenar los factores y sus cuentas.
        Map<Long, Integer> factors = new HashMap<>();

        // 1. Empezamos con el divisor más pequeño, 2.
        // El bucle se detiene en la raíz cuadrada de n como optimización clave.
        for (long divisor = 2; divisor * divisor <= n; divisor++) {
            // 2. Mientras el número sea divisible por el divisor actual...
            while (n % divisor == 0) {
                // ...incrementamos la cuenta de ese factor primo.
                // getOrDefault es perfecto para esto: retorna 0 si no existe, 0+1=1
                factors.put(divisor, factors.getOrDefault(divisor, 0) + 1);

                // ...y dividimos el número, reduciendo el problema.
                n /= divisor;
            }
        }

        // 3. Si queda un número mayor que 1, ese número restante es primo.
        // Esto maneja el caso de que el factor primo más grande aparezca solo una vez.
        // Por ejemplo, para n=30:
        //   - 30 ÷ 2 = 15 → {2: 1}
        //   - 15 ÷ 3 = 5  → {2: 1, 3: 1}
        //   - 5 no es divisible por 2, 3, o 4 (4² = 16 > 5)
        //   - queda n=5, se agrega → {2: 1, 3: 1, 5: 1}
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }

        return factors;
    }

    /**
     * Método main para pruebas y demostración.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        PrimeFactorizer factorizer = new PrimeFactorizer();

        // Ejemplo 1: 24 = 2³ × 3
        long numberToFactor = 24;
        Map<Long, Integer> result = factorizer.factor(numberToFactor);
        System.out.println("La factorización prima de " + numberToFactor + " es: " + result);
        // Salida esperada: La factorización prima de 24 es: {2=3, 3=1}

        // Ejemplo 2: 30 = 2 × 3 × 5
        numberToFactor = 30;
        result = factorizer.factor(numberToFactor);
        System.out.println("La factorización prima de " + numberToFactor + " es: " + result);
        // Salida esperada: La factorización prima de 30 es: {2=1, 3=1, 5=1}
    }
}
