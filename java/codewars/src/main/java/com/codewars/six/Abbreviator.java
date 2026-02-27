package com.codewars.six;

/**
 * Abreviador inteligente que reduce palabras largas a forma abreviada.
 *
 * Reglas de abreviación:
 * - Palabras con ≤ 3 caracteres: se mantienen igual
 * - Palabras con > 3 caracteres: se abrevian como: 1erLetra + (cantidad-2) + últimaLetra
 * - Caracteres no-letra: se mantienen sin cambios
 * - Se preserva la capitalización
 *
 * Ejemplos:
 *   "internationalization" (20 letras) → "i18n"
 *   "accessibility" (13 letras)        → "a11y"
 *   "Accessibility" (13 letras)        → "A11y" (preserva mayúscula)
 *   "elephant-ride" (dos palabras)     → "e6t-r2e"
 *   "are"                              → "are" (3 letras, no se abrevia)
 *   "really"                           → "r4y" (5 letras)
 *   "fun!"                             → "fun!" (no se abrevia, < 3 letras)
 *
 * @author Codewars Level 6
 */
public class Abbreviator {

    /**
     * Abrevia una cadena según las reglas de abreviación.
     *
     * Algoritmo:
     * 1. Itera sobre cada carácter del string
     * 2. Si es una letra:
     *    a. Extrae la palabra completa (secuencia de letras)
     *    b. Si palabra.length() > 3:
     *       - Crea abreviatura: primera letra + (length-2) + última letra
     *    c. Si palabra.length() ≤ 3:
     *       - Mantiene la palabra sin cambios
     * 3. Si NO es una letra:
     *    - Agrega el carácter tal cual (espacio, puntuación, guiones, etc.)
     * 4. Retorna la cadena abreviada
     *
     * Complejidad temporal: O(n) donde n es la longitud del string
     * Complejidad espacial: O(n) para el resultado
     *
     * @param string la cadena a abreviar
     * @return la cadena con palabras largas abreviadas
     */
    public String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < string.length()) {
            // ¿Es el carácter en posición i una letra?
            if (Character.isLetter(string.charAt(i))) {
                // Construimos la palabra completa
                StringBuilder word = new StringBuilder();
                while (i < string.length() && Character.isLetter(string.charAt(i))) {
                    word.append(string.charAt(i));
                    i++;
                }

                // Decidimos qué hacer con la palabra
                // Si tiene más de 3 letras: abreviamos
                // Si tiene 3 o menos: la mantenemos
                if (word.length() > 3) {
                    // Formato: primera letra + cantidad de letras interiores + última letra
                    String abbreviated = word.charAt(0)
                        + String.valueOf(word.length() - 2)
                        + word.charAt(word.length() - 1);
                    result.append(abbreviated);
                } else {
                    // Palabra corta: sin cambios
                    result.append(word.toString());
                }

            } else {
                // Carácter no-letra: se mantiene tal cual
                result.append(string.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    /**
     * Método main para pruebas y demostración.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Abbreviator ab = new Abbreviator();
        System.out.println(ab.abbreviate("internationalization")); // i18n
        System.out.println(ab.abbreviate("accessibility")); // a11y
        System.out.println(ab.abbreviate("Accessibility")); // A11y
        System.out.println(ab.abbreviate("elephant-ride")); // e6t-r2e
        System.out.println(ab.abbreviate("elephant-rides are really fun!")); // e6t-r3s are r4y fun!
        System.out.println(ab.abbreviate("You need, need not want, to complete this code-wars mission")); // You n2d, n2d not w2t, to c6e this c2e-w2s m5n
    }
}
