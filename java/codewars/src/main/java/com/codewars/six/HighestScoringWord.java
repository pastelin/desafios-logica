package com.codewars.six;

/**
 * Encuentra la palabra con la puntuación más alta en un string.
 *
 * Cada letra tiene un valor según su posición en el alfabeto:
 * a=1, b=2, c=3, ..., z=26
 *
 * La puntuación de una palabra es la suma de los valores de sus letras.
 *
 * Ejemplos:
 *   "abad" → 1+2+1+4 = 8
 *   "taxi" → 20+1+24+9 = 54
 *   "man i need a taxi up to ubud" → "taxi" (puntuación 54)
 *
 * Desempates: Si dos palabras tienen la misma puntuación,
 * retorna la que aparece primero en el string original.
 *
 * @author Codewars Level 6
 */
public class HighestScoringWord {

    /**
     * Encuentra la palabra con mayor puntuación alfabética.
     *
     * Algoritmo:
     * 1. Divide el string en palabras usando espacios como delimitador
     * 2. Inicializa variables para rastrear el máximo
     * 3. Para cada palabra:
     *    a. Calcula puntuación: suma de (carácter - 'a' + 1) para cada letra
     *    b. Si puntuación > máximo previo: actualiza máximo y palabra
     * 4. Retorna la palabra con mayor puntuación
     *
     * Complejidad temporal: O(n * m) donde n = cantidad de palabras, m = longitud promedio
     * Complejidad espacial: O(n) para el array de palabras
     *
     * @param s string de palabras separadas por espacios
     * @return la palabra con mayor puntuación alfabética
     */
    public static String high(String s) {
        // Divide el string en palabras
        String[] words = s.split(" ");

        int max = 0;
        String maxWord = "";

        // Itera sobre cada palabra
        for (String word : words) {
            // Calcula la puntuación de la palabra
            // word.chars() crea un stream de valores ASCII de los caracteres
            // map(c -> c - 'a' + 1) convierte cada carácter a su valor alfabético
            // sum() suma todos los valores
            int sum = word.chars().map(c -> c - 'a' + 1).sum();

            // Actualiza el máximo si esta palabra tiene puntuación mayor
            if (sum > max) {
                max = sum;
                maxWord = word;
            }
        }

        return maxWord;
    }

    /**
     * Método main para pruebas.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println(high("man i need a taxi up to ubud"));
    }
}
