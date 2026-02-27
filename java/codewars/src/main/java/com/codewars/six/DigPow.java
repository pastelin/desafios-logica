package com.codewars.six;

import java.util.ArrayList;
import java.util.List;

/**
 * Determina si un número es un "número potencia de dígitos" (Power Number).
 *
 * Definición: Un número n es válido si existe un número k tal que:
 * n * k = suma de (cada dígito elevado a potencias consecutivas)
 *
 * Ejemplos:
 *   - 89 con p=1: 8¹ + 9² = 8 + 81 = 89
 *     89 * 1 = 89, entonces k=1
 *   - 135 con p=1: 1¹ + 3² + 5³ = 1 + 9 + 125 = 135
 *     135 * 1 = 135, entonces k=1
 *   - 10 con p=2: 1² + 0³ = 1 + 0 = 1
 *     1 no es divisible por 10, entonces k=-1
 *
 * @author Codewars Level 6
 */
public class DigPow {

    /**
     * Calcula si un número n puede expresarse como la suma de sus dígitos
     * elevados a potencias consecutivas empezando desde p.
     *
     * Si es válido, retorna el multiplicador k tal que n * k = suma.
     * Si no es válido, retorna -1.
     *
     * Algoritmo:
     * 1. Extrae los dígitos del número en orden correcto
     * 2. Suma cada dígito elevado a potencias consecutivas (p, p+1, p+2, ...)
     * 3. Verifica si la suma es divisible por n
     * 4. Si sí: retorna la división (multiplicador k)
     *    Si no: retorna -1
     *
     * Ejemplos:
     *   digPow(89, 1)   → 1  (8¹ + 9² = 89, 89 / 89 = 1)
     *   digPow(135, 1)  → 1  (1¹ + 3² + 5³ = 135, 135 / 135 = 1)
     *   digPow(10, 2)   → -1 (1² + 0³ = 1, 1 % 10 ≠ 0)
     *
     * Complejidad temporal: O(d * p) donde d = número de dígitos, p = potencia
     * Complejidad espacial: O(d) para almacenar los dígitos
     *
     * @param n El número positivo a evaluar
     * @param p La potencia inicial (punto de partida)
     * @return El multiplicador k si existe, -1 si no existe
     */
    public static long digPow(int n, int p) {
        // Inicializa la suma de dígitos elevados a potencias
        int sum = 0;

        // Extrae los dígitos del número y los almacena en el orden correcto
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            digits.add(0, temp % 10); // Agrega al inicio para mantener orden
            temp /= 10;
        }

        // Calcula la suma de dígitos elevados a potencias consecutivas
        for (int digit : digits) {
            sum += Math.pow(digit, p);
            p++; // Incrementa la potencia para el siguiente dígito
        }

        // Verifica si la suma es divisible por el número original
        return (sum % n == 0) ? sum / n : -1;
    }

    /**
     * Método main para pruebas.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int n = 89;
        int p = 1;
        long result = digPow(n, p);
        if (result != -1) {
            System.out.println("The number " + n + " is a valid power number with k = " + result);
        } else {
            System.out.println("The number " + n + " is not a valid power number.");
        }
    }
}
