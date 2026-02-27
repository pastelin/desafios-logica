package com.codewars.six;

public class SubpatternRecognitionI {

    /**
     * Checks if the input string is entirely composed of repeated occurrences
     * of a subpattern. If such a subpattern exists, the method returns true;
     * otherwise, it returns false.
     *
     * @param str the input string to check
     * @return true if the string is composed of repeated subpatterns, false otherwise
     */
    public static boolean hasSubpattern(String str) {

        int length = str.length();

        // A single-character string cannot have a repeating subpattern
        if (length == 1) {
            return false;
        }

        // Iterate through possible subpattern lengths
        for (int i = 1; i <= length / 2; i++) {

            // Check if the current length divides the string evenly
            if (length % i == 0) {
                String pattern = str.substring(0, i);

                // Check if repeating the subpattern forms the original string
                if (pattern.repeat(length / i).equals(str)) {
                    return true;
                }
            }
        }

        // No repeating subpattern found
        return false;
    }
}
