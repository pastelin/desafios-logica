package com.codewars.seven;

/**
 * Procesa un tweet reemplazando "coverage" con "covfefe".
 *
 * Origen: Basado en el famoso tweet del 31 de mayo de 2017 donde se escribió
 * "Despite the constant negative press covfefe" en lugar de "coverage".
 *
 * Lógica:
 * - Si el tweet contiene "coverage": reemplaza TODAS las ocurrencias por "covfefe"
 * - Si no contiene "coverage": agrega " covfefe" al final del tweet
 *
 * Ejemplos:
 *   "I love the coverage of the news" → "I love the covfefe of the news"
 *   "This is a tweet"                  → "This is a tweet covfefe"
 *   ""                                 → " covfefe" (string vacío + covfefe)
 *
 * @author Codewars Level 7
 */
public class Covfefe {

    /**
     * Aplica la transformación covfefe al tweet.
     *
     * Algoritmo:
     * - Verifica si el tweet contiene la palabra "coverage"
     * - Si sí: reemplaza todas las ocurrencias con replaceAll()
     * - Si no: concatena " covfefe" al final
     *
     * Nota: La búsqueda es case-sensitive. "Coverage" o "COVERAGE" no coincidirán.
     *
     * Complejidad temporal: O(n) donde n es la longitud del string
     * Complejidad espacial: O(n) para el resultado del replaceAll
     *
     * @param tweet el texto del tweet a procesar
     * @return el tweet transformado con la regla covfefe
     */
    public static String covfefe(String tweet) {
        return (tweet.contains("coverage"))
            ? tweet.replaceAll("coverage", "covfefe")
            : tweet.concat(" covfefe");
    }

}
