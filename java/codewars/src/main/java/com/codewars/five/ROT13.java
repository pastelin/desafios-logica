package com.codewars.five;

/*
 * How can you tell an extrovert from an introvert at NSA?
 * Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.

 * I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
 * According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.

 * For this task you're only supposed to substitute characters.
 * Not spaces, punctuation, numbers, etc.

 * Test examples:
 * "EBG13 rknzcyr." -> "ROT13 example."
 * "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
 *
 * */
public class ROT13 {

    /*
    * The rot13 method is designed to perform the ROT13 substitution cipher on a given string.
    * This cipher replaces each letter with the letter 13 positions after it in the alphabet, wrapping around if necessary.
    * The method takes a single parameter, message, which is the string to be encoded.
    * */
    public static String rot13(String message) {
        // First, a StringBuilder named result is initialized to build the encoded string:
        StringBuilder result = new StringBuilder();

        // The method then iterates over each character in the input string using a for loop:
        for (char c : message.toCharArray()) {

            // Within the loop, it checks if the character is a letter and not a diacritic using the Character.isLetter method and a custom isDiacritic method:
            if (Character.isLetter(c) && !isDiacritic(c)) {
                // If the character is a letter and not a diacritic, it determines the base character ('a' for lowercase and 'A' for uppercase) and calculates the ROT13 transformation:
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + 13) % 26 + base));
            } else {
                // If the character is not a letter or is a diacritic, it is appended to the result without modification:
                result.append(c);
            }
        }

        // Finally, the method returns the encoded string:
        return result.toString();
    }

    // he isDiacritic method checks if a character is one of the specified diacritic characters by searching for it in a predefined string:
    private static boolean isDiacritic(char c) {
        return "äëïöüÄËÏÖÜ".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(rot13("W3 ar3 in ye@r 2023$$$!äöü"));
    }

}
