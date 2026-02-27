package com.codewars.seven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cuenta la cantidad de consonantes en un string.
 *
 * Objetivo: Procesar un string e contar cuántas letras son consonantes.
 *
 * Definición: Consonante es cualquier letra que NO sea vocal (a, e, i, o, u).
 * - Ignora dígitos, espacios y caracteres especiales
 * - Case-insensitive (A, E, I, O, U también son vocales)
 *
 * Ejemplos:
 *   "hello world"   → 7 (h,l,l,w,r,l,d)
 *   "aeiou"         → 0 (todas son vocales)
 *   "bcdfg"         → 5 (todas son consonantes)
 *   "Hello123!"     → 3 (H,l,l)
 *
 * @author Codewars Level 7
 */
public class Consonants {

    /**
     * Cuenta consonantes usando enfoque iterativo con Regex.
     *
     * Algoritmo:
     * 1. Compila un patrón que coincide con letras [a-zA-Z]
     * 2. Convierte el string a array de caracteres
     * 3. Itera sobre cada carácter
     * 4. Verifica si es letra Y NO es una de las 5 vocales (aeiou)
     * 5. Incrementa el contador si ambas condiciones son verdaderas
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(n) para el array de caracteres
     *
     * @param str el string a procesar
     * @return cantidad de consonantes encontradas
     */
    public static int getCount(String str) {
        String regex = "[a-zA-Z]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        char[] letters = str.toCharArray();
        int index = 0;

        for(int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);
            Matcher matcher = pattern.matcher(letter);

            // Verifica que sea letra Y que NO sea vocal
            if(matcher.find() && !("aeiou").contains(String.valueOf(letters[i]))) {
                index++;
            }
        }

        return index;
    }

    /**
     * Cuenta consonantes usando Streams (enfoque funcional).
     *
     * Algoritmo:
     * 1. str.chars() crea stream de valores ASCII de caracteres
     * 2. mapToObj() convierte ASCII a objetos Character
     * 3. filter() aplica el mismo criterio de consonante
     * 4. count() suma los elementos que pasaron el filtro
     *
     * Nota: Comparte la misma lógica que getCount() pero usa programación funcional.
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(1) (Streams no almacenan todos los datos)
     *
     * @param str el string a procesar
     * @return cantidad de consonantes encontradas
     */
    public static int getCountOptimized(String str) {
        String regex = "[a-zA-Z]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        return (int) str.chars()
                .mapToObj(i -> (char) i)
                .filter((letter) -> {
                    String letterStr = String.valueOf(letter);
                    Matcher matcher = pattern.matcher(letterStr);
                    return matcher.find() && !("aeiou").contains(letterStr);
                })
                .count();
    }

    /**
     * Cuenta consonantes usando regex puro (enfoque refactorizado).
     *
     * Algoritmo:
     * 1. Usa replaceAll() con patrón regex para eliminar:
     *    - [aeiou\\d\\W_]: vocales, dígitos, caracteres no-palabra y guiones bajos
     *    - (?i): flag para ignorar mayúsculas/minúsculas
     * 2. El resultado es un string solo con consonantes
     * 3. .length() retorna la cantidad de consonantes
     *
     * Ventajas: Más compacto y eficiente, una sola pasada por el string.
     *
     * Complejidad temporal: O(n)
     * Complejidad espacial: O(n) para el resultado del replaceAll
     *
     * @param str el string a procesar
     * @return cantidad de consonantes encontradas
     */
    public static int getCountRefactorized(final String str) {
        // (?i) = case-insensitive
        // [aeiou\\d\\W_] = vocales O dígitos O caracteres no-palabra O guiones bajos
        return str.replaceAll("(?i)[aeiou\\d\\W_]", "").length();
    }

}
