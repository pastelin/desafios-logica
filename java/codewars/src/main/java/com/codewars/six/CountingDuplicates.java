package com.codewars.six;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {


    /**
     * Cuenta el número de caracteres que aparecen más de una vez en el texto dado.
     *
     * @param text El texto de entrada (puede contener letras y números).
     * @return El número de caracteres duplicados (ignorando mayúsculas/minúsculas).
     */
    public static int duplicateCount(String text) {
        // Validación de entrada: manejar casos nulos o vacíos.
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Convertir el texto a minúsculas para ignorar diferencias de mayúsculas/minúsculas.
        text = text.toLowerCase();

        // Mapa para contar la frecuencia de cada carácter.
        Map<Character, Integer> charCount = new HashMap<>();

        // Contar la frecuencia de cada carácter en el texto.
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Contar cuántos caracteres tienen una frecuencia mayor a 1.
        int duplicates = 0;
        for (int count : charCount.values()) {
            if (count > 1) {
                duplicates++;
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

}
