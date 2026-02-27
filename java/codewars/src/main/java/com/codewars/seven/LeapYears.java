package com.codewars.seven;

/**
 * Determina si un año es bisiesto según el calendario gregoriano.
 *
 * Reglas de años bisiestos:
 * 1. Un año es bisiesto si es divisible por 4
 * 2. EXCEPTO si es divisible por 100 (entonces NO es bisiesto)
 * 3. EXCEPTO si es divisible por 400 (entonces SÍ es bisiesto)
 *
 * Ejemplos:
 *   - 2000: divisible por 400 → SÍ es bisiesto
 *   - 1900: divisible por 100 pero no 400 → NO es bisiesto
 *   - 2004: divisible por 4 pero no 100 → SÍ es bisiesto
 *   - 2001: no divisible por 4 → NO es bisiesto
 *
 * @author Codewars Level 7
 */
public class LeapYears {

    /**
     * Determina si un año es bisiesto.
     *
     * Utiliza un ternario anidado para aplicar las reglas:
     * - Si es divisible por 100: solo es bisiesto si también lo es por 400
     * - Si no es divisible por 100: es bisiesto si es divisible por 4 O por 400
     *
     * Nota: El segundo OR (year % 400 == 0) es redundante pero mantiene
     * la lógica clara. Si ya pasó el check de 100, no puede ser divisible por 400.
     *
     * Complejidad: O(1) - solo operaciones aritméticas
     *
     * @param year el año a verificar (entero positivo válido)
     * @return true si es año bisiesto, false en caso contrario
     */
    public static boolean isLeapYear(int year) {
        return (year % 100 == 0)
            ? (year % 400 == 0)
            : (year % 4 == 0);
    }
}
