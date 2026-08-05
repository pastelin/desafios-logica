//package com.codewars.five;
//
//import static ROT13.rot13;
//
///**
// * Implementa el cifrado ROT13 (Rotation 13).
// *
// * ROT13 es una forma simple de cifrado por sustitución que reemplaza una letra
// * por la que se encuentra 13 posiciones adelante en el alfabeto.
// *
// * Características:
// * - Es un cifrado de sustitución monoalfabético
// * - Es su propio inverso: aplicar ROT13 dos veces devuelve el texto original
// * - Usado frecuentemente en USENET para ofuscar chistes y spoilers
// * - Preserva espacios, puntuación, números y diacríticos
// *
// * Ejemplos:
// *   "EBG13 example."        → "ROT13 rknzcyr."
// *   "This is my first ROT13" → "Guvf vf zl svefg EBG13"
// *   "The quick brown fox"   → "Gur dhvpx oebja sbk"
// *
// * @author Codewars Level 5
// * @see <a href="https://en.wikipedia.org/wiki/ROT13">ROT13 en Wikipedia</a>
// */
//public class ROT13 {
//
//    /**
//     * Aplica la transformación ROT13 a un mensaje.
//     *
//     * Algoritmo:
//     * 1. Recorre cada carácter del mensaje
//     * 2. Si es una letra (a-z, A-Z):
//     *    a. Determina la base ('a' para minúsculas, 'A' para mayúsculas)
//     *    b. Calcula el desplazamiento: (c - base + 13) % 26
//     *    c. Convierte de vuelta a carácter
//     * 3. Si no es letra o es diacrítico: se mantiene sin cambios
//     *
//     * Complejidad temporal: O(n) donde n es la longitud del mensaje
//     * Complejidad espacial: O(n) para el StringBuilder
//     *
//     * @param message el texto a cifrar con ROT13
//     * @return el mensaje cifrado con ROT13
//     */
//    public static String rot13(String message) {
//        // Inicializa un StringBuilder para construir el resultado de forma eficiente
//        StringBuilder result = new StringBuilder();
//
//        // Itera sobre cada carácter del mensaje
//        for (char c : message.toCharArray()) {
//
//            // Verifica si es una letra válida (no un diacrítico)
//            if (Character.isLetter(c) && !isDiacritic(c)) {
//                // Determina si es mayúscula o minúscula para usar la base correcta
//                char base = Character.isLowerCase(c) ? 'a' : 'A';
//                // Aplica ROT13: desplaza 13 posiciones, wraps around con módulo 26
//                result.append((char) ((c - base + 13) % 26 + base));
//            } else {
//                // Caracteres no-letra se mantienen sin cambios
//                result.append(c);
//            }
//        }
//
//        // Retorna el mensaje transformado
//        return result.toString();
//    }
//
//    /**
//     * Verifica si un carácter es un diacrítico (acento).
//     *
//     * Los diacríticos no deben transformarse con ROT13 para preservar
//     * la integridad de caracteres en otros idiomas.
//     *
//     * Actualmente soporta: äëïöüÄËÏÖÜ
//     *
//     * @param c el carácter a verificar
//     * @return true si es un diacrítico, false en caso contrario
//     */
//    private static boolean isDiacritic(char c) {
//        return "äëïöüÄËÏÖÜ".indexOf(c) >= 0;
//    }
//
//}
//
////    public static void main(String[] args) {
////        System.out.println(ROT13.rot13("W3 ar3 in ye@r 2023$$$!äöü"));
////    }
//
//}
