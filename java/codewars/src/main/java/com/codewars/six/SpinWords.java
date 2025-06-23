package com.codewars.six;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpinWords {

    public static void main(String[] args) {
        System.out.println(spinWords("This is a test")); // "This is a test"
        System.out.println(spinWords("This is another test")); // "This is rehtona test"
        System.out.println(spinWords("Hello world")); // "olleH dlrow"
    }

    /**
     * Método que invierte las palabras de una oración que tienen 5 o más caracteres.
     *
     * @param sentence La oración de entrada.
     * @return La oración con las palabras de 5 o más caracteres invertidas.
     */
    public static Object spinWords(String sentence) {

        // Divide la oración en palabras, invierte las que tienen 5 o más caracteres y las une nuevamente.
        return Stream.of(sentence.split(" "))
                .map(word -> word.length() >= 5 ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }
}
