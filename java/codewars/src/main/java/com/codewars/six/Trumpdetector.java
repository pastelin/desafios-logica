package com.codewars.six;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trumpdetector {


    public static double detect(String trumpySpeech) {
        // La descripción garantiza que siempre habrá al menos una vocal.
        if (trumpySpeech == null || trumpySpeech.isEmpty()) {
            return 0.0;
        }

        // Convertimos a minúsculas para un manejo de casos insensible.
        String lowerCaseText = trumpySpeech.toLowerCase();

        double extraVowels = 0;
        double baseVowels = 0;
        char previousChar = ' '; // Un caracter inicial que no sea vocal.

        // Recorremos cada caracter del texto.
        for (int i = 0; i < lowerCaseText.length(); i++) {
            char currentChar = lowerCaseText.charAt(i);

            if ("aeiou".indexOf(currentChar) != -1) {
                // Comparamos con el caracter anterior.
                if (currentChar == previousChar) {
                    // Si es la misma vocal consecutiva, es una vocal "extra".
                    extraVowels++;
                } else {
                    // Si es una vocal diferente a la anterior (o la primera),
                    // es una nueva "vocal base".
                    baseVowels++;
                }
            }
            // Actualizamos el caracter anterior para la siguiente iteración.
            previousChar = currentChar;
        }

        if (baseVowels == 0) {
            return 0.0;
        }

        // Calculamos el resultado como un double.
        double score = extraVowels / baseVowels;

        // Redondeamos el resultado a dos decimales.
        // Usar BigDecimal es la forma más precisa y segura de redondear en Java.
        BigDecimal bd = new BigDecimal(Double.toString(score));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(detect("I will build a huge wall"));
    }


}
