package com.codewars.six;

public class Encrypt {

    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        StringBuilder encryptedText = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            StringBuilder encryptedWord = new StringBuilder();

            // Convert first character to ASCII
            encryptedWord.append((int) word.charAt(0));

            if (word.length() > 2) {
                // Swap second and last characters
                encryptedWord.append(word.charAt(word.length() - 1));
                encryptedWord.append(word, 2, word.length() - 1);
                encryptedWord.append(word.charAt(1));

            } else if (word.length() == 2) {
                // Just append the second character
                encryptedWord.append(word.charAt(1));
            }
            // For single character words, nothing more to append
            encryptedText.append(encryptedWord).append(" ");
        }
        return encryptedText.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(encryptThis("A wise old owl lived in an oak")); // "72olle"
        System.out.println(encryptThis("good"));  // "103doo"
        System.out.println(encryptThis("A"));     // "65"
        System.out.println(encryptThis("ab"));    // "97b"
        System.out.println(encryptThis(""));      // ""
    }
}
