package com.codewars.six;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents Vicky, a robot that can learn words.
 */
public class Robot {

    // A HashSet is used to store known words for efficient look-up (O(1) average time complexity).
    private final Set<String> knownWords;

    /**
     * Constructor for the Robot.
     * Initializes Vicky with a pre-set vocabulary based on the problem's "trick".
     */
    public Robot() {
        // The "trick" is that Vicky already knows the words she uses in her responses.
        // We initialize her vocabulary with these words in lowercase.
        String[] initialWords = {
                "thank", "you", "for", "teaching", "me", "i", "already",
                "know", "the", "word", "do", "not", "understand", "input"
        };
        this.knownWords = new HashSet<>(Arrays.asList(initialWords));
    }

    /**
     * Attempts to teach the robot a new word.
     *
     * @param word The word to be learned.
     * @return A response indicating whether the word was learned, already known, or invalid.
     */
    public String learnWord(String word) {
        // Step 1: Validate the input.
        // A valid word must not be null and must contain only alphabetical characters.
        // We use a regular expression "[a-zA-Z]+" to check this.
        if (word == null || !word.matches("[a-zA-Z]+")) {
            return "I do not understand the input";
        }

        // Step 2: Normalize the word to handle case-insensitivity.
        // We convert the input to lowercase to store and check it consistently.
        String lowerCaseWord = word.toLowerCase();

        // Step 3: Attempt to add the word to the set of known words.
        // The .add() method of a Set is perfect here. It returns 'true' if the item
        // was added (because it was new), and 'false' if the item was already present.
        if (knownWords.add(lowerCaseWord)) {
            // If .add() returns true, it's a new word.
            return "Thank you for teaching me " + lowerCaseWord;
        } else {
            // If .add() returns false, the robot already knew the word.
            return "I already know the word " + lowerCaseWord;
        }
    }

    /**
     * Main method for demonstration purposes.
     */
    public static void main(String[] args) {
        Robot vicky = new Robot();
        System.out.println(vicky.learnWord("hello"));      // -> "Thank you for teaching me hello"
        System.out.println(vicky.learnWord("abc"));        // -> "Thank you for teaching me abc"
        System.out.println(vicky.learnWord("hello"));      // -> "I already know the word hello"
        System.out.println(vicky.learnWord("Hello"));      // -> "I already know the word hello" (case-insensitive)
        System.out.println(vicky.learnWord("wow!"));       // -> "I do not understand the input"
        System.out.println(vicky.learnWord(""));           // -> "I do not understand the input"
        System.out.println(vicky.learnWord("thank"));      // -> "I already know the word thank" (from initial vocab)
    }
}
