package com.codewars.six;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactorizer {

    /**
     * Calcula los factores primos de un número dado y sus multiplicidades.
     *
     * @param n El número long positivo a factorizar.
     * @return Un Map donde las claves son los factores primos y los valores son sus multiplicidades.
     */
    public java.util.Map<Long, Integer> factor(long n) {
        // Usamos un HashMap para almacenar los factores y sus cuentas.
        Map<Long, Integer> factors = new HashMap<>();

        // 1. Empezamos con el divisor más pequeño, 2.
        // El bucle se detiene en la raíz cuadrada de n como optimización.
        for (long divisor = 2; divisor * divisor <= n; divisor++) {
            // 2. Mientras el número sea divisible por el divisor actual...
            while (n % divisor == 0) {
                // ...incrementamos la cuenta de ese factor primo.
                // getOrDefault es perfecto para esto.
                factors.put(divisor, factors.getOrDefault(divisor, 0) + 1);

                // ...y dividimos el número, reduciendo el problema.
                n /= divisor;
            }
        }

        // 3. Si queda un número mayor que 1, ese número restante es primo.
        // Esto maneja el caso de que el factor primo más grande aparezca solo una vez.
        // Por ejemplo, para n=30, después de dividir por 2 y 3, queda n=5.
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }

        return factors;
    }

    public static void main(String[] args) {
        PrimeFactorizer factorizer = new PrimeFactorizer();
        long numberToFactor = 24;
        Map<Long, Integer> result = factorizer.factor(numberToFactor);

        System.out.println("La factorización prima de " + numberToFactor + " es: " + result);
        // Salida esperada: La factorización prima de 24 es: {2=3, 3=1}

        numberToFactor = 30;
        result = factorizer.factor(numberToFactor);
        System.out.println("La factorización prima de " + numberToFactor + " es: " + result);
        // Salida esperada: La factorización prima de 30 es: {2=1, 3=1, 5=1}
    }
}
