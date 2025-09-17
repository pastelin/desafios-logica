package com.codewars.six;

public class ConvertStringToCamelCase {

    static String toCamelCase(String s) {

        // Split the string into words using '-' or '_' as delimiters
        String[] words = s.split("[-_]");

        // Use StringBuilder for efficient string concatenation
        StringBuilder camelCase = new StringBuilder(words[0]);

        // Capitalize the first letter of each subsequent word and append
        for (int i = 1; i < words.length; i++) {
            camelCase.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1));
        }

        return camelCase.toString();
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("the_Stealth_Warrior"));
    }


}
