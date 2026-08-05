package com.codewars.six;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Utilidad para convertir frases separadas por espacios en formato PascalCase.
 * <p>
 * Ejemplo: "hello case" -> "HelloCase"
 * </p>
 */
public class PascalCase {

    /**
     * Convierte un texto en PascalCase recorriendo palabra por palabra.
     *
     * @param str texto de entrada; puede contener varios espacios entre palabras
     * @return cadena en PascalCase; devuelve "" si la entrada es null o vacia
     */
    public static String camelCase(String str) {

        // Evita errores con null y define una salida predecible para entrada vacia.
        if (str == null || str.trim().isEmpty()) {
            return "";
        }

        // trim() limpia espacios en extremos y split("\\s+") separa por uno o mas espacios.
        String[] strArr = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String value : strArr) {
            // Toma la primera letra en mayuscula y concatena el resto de la palabra.
            result.append(Character.toUpperCase(value.charAt(0))).append(value.substring(1));
        }

        return result.toString();
    }

    /**
     * Misma conversion a PascalCase, pero usando Stream API.
     *
     * @param str texto de entrada; puede contener varios espacios entre palabras
     * @return cadena en PascalCase; devuelve "" si la entrada es null o vacia
     */
    public static String camelCaseWithStream(String str) {

        if (str == null || str.trim().isEmpty()) {
            return "";
        }

        return Arrays.stream(str.trim().split("\\s+"))
                .map(value -> Character.toUpperCase(value.charAt(0)) + value.substring(1))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(camelCase("hello case")); // HelloCase
        System.out.println(camelCaseWithStream("hello case")); // HelloCase

    }
}
