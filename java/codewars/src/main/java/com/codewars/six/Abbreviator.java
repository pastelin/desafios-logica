package com.codewars.six;

public class Abbreviator {

    public String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < string.length()) {
            // Is the character at i a letter?
            if (Character.isLetter(string.charAt(i))) {
                StringBuilder word = new StringBuilder();
                while (i < string.length() && Character.isLetter(string.charAt(i))) {
                    word.append(string.charAt(i));
                    i++;
                }
                // Now that we have a word, what do we do with it?
                result.append(word.toString().length() > 3 ? word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1) : word.toString());

            } else {
                result.append(string.charAt(i));
                i++;
            }

        }

        return result.toString();
    }

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
