package com.codewars.six;

/**
 * Convierte strings con separadores a notación camelCase.
 *
 * Objetivo: Transformar una cadena con palabras separadas por guiones (-)
 * o guiones bajos (_) a formato camelCase (primera palabra minúscula,
 * resto con primera letra mayúscula).
 *
 * Ejemplos:
 *   "the_stealth_warrior"   → "theStealthWarrior"
 *   "the-stealth-warrior"   → "theStealthWarrior"
 *   "my-name-is-john"       → "myNameIsJohn"
 *   "some_mixed-case_words" → "someMixedCaseWords"
 *
 * @author Codewars Level 6
 */
public class ConvertStringToCamelCase {

    /**
     * Transforma un string a camelCase.
     *
     * Algoritmo:
     * 1. Divide el string usando regex que coincide con '-' o '_'
     * 2. Inicia con la primera palabra (sin capitalizar)
     * 3. Para cada palabra subsecuente:
     *    a. Capitaliza la primera letra
     *    b. Mantiene el resto de la palabra sin cambios
     * 4. Concatena todas las palabras sin separadores
     *
     * Complejidad temporal: O(n) donde n es la longitud del string
     * Complejidad espacial: O(n) para el StringBuilder y array de palabras
     *
     * @param s string con palabras separadas por '-' o '_'
     * @return el string convertido a formato camelCase
     */
    static String toCamelCase(String s) {

        // Divide el string en palabras usando '-' o '_' como delimitadores
        String[] words = s.split("[-_]");

        // Usa StringBuilder para concatenación eficiente
        StringBuilder camelCase = new StringBuilder(words[0]);

        // Capitaliza la primera letra de cada palabra subsecuente
        for (int i = 1; i < words.length; i++) {
            camelCase.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1));
        }

        return camelCase.toString();
    }

    /**
     * Método main para pruebas.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println(toCamelCase("the_Stealth_Warrior"));
    }


}
