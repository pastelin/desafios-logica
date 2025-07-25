package com.baires.dev.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {


    // Map to store adjacent digits for each key on the keypad
    // Key: original digit (char)
    // Value: array of adjacent digits (char[]) including the digit itself
    private static final Map<Character, char[]> ADJACENT_DIGITS = new HashMap<>();

    static {
        ADJACENT_DIGITS.put('0', new char[]{'0', '8'});
        ADJACENT_DIGITS.put('1', new char[]{'1', '2', '4'});
        ADJACENT_DIGITS.put('2', new char[]{'1', '2', '3', '5'});
        ADJACENT_DIGITS.put('3', new char[]{'2', '3', '6'});
        ADJACENT_DIGITS.put('4', new char[]{'1', '4', '5', '7'});
        ADJACENT_DIGITS.put('5', new char[]{'2', '4', '5', '6', '8'});
        ADJACENT_DIGITS.put('6', new char[]{'3', '5', '6', '9'});
        ADJACENT_DIGITS.put('7', new char[]{'4', '7', '8'});
        ADJACENT_DIGITS.put('8', new char[]{'0', '5', '7', '8', '9'});
        ADJACENT_DIGITS.put('9', new char[]{'6', '8', '9'});
    }

    /**
     * Finds all possible PIN variations based on the observed PIN and keypad adjacencies.
     * The variations include the observed PIN itself and all combinations considering adjacent digits
     * (horizontally or vertically, not diagonally).
     *
     * @param observedPin The PIN observed by the informant, in string format.
     * @return An array of strings containing all possible PINs, ordered in ascending value.
     */
    public static String[] solution(String observedPin) {
        // Use a TreeSet to automatically store unique PINs and keep them sorted
        // We will convert to Integer for numerical sorting later, then back to String
        Set<String> possiblePins = new TreeSet<>((s1, s2) -> {
            // Convert strings to Long for numerical comparison to handle large PINs
            // If parsing fails, fall back to string comparison (though unlikely with valid digits)
            try {
                return Long.compare(Long.parseLong(s1), Long.parseLong(s2));
            } catch (NumberFormatException e) {
                return s1.compareTo(s2); // Fallback for non-numeric strings, though not expected
            }
        });

        // Start the recursive generation of PINs
        generatePins(observedPin.toCharArray(), 0, new StringBuilder(), possiblePins);

        // Convert the TreeSet to a List and then to an array
        List<String> sortedPinsList = new ArrayList<>(possiblePins);

        // The TreeSet sorts based on the custom comparator, so it's already sorted.
        // No need for Collections.sort() here if TreeSet's comparator is sufficient.
        // However, if the custom comparator for TreeSet is not robust for all cases (e.g., leading zeros handling),
        // it's safer to sort the final list numerically.
        // For PINs, leading zeros are important if they are part of the number's representation,
        // but for numerical sorting, "01" is "1". The problem implies numerical sorting.

        // Final sort to ensure ascending numerical order, converting to Long for comparison
        Collections.sort(sortedPinsList, (s1, s2) -> {
            try {
                return Long.compare(Long.parseLong(s1), Long.parseLong(s2));
            } catch (NumberFormatException e) {
                // This case should ideally not happen if input is valid digits
                return s1.compareTo(s2);
            }
        });


        return sortedPinsList.toArray(new String[0]);
    }

    /**
     * Recursive helper function to generate all possible PIN combinations.
     *
     * @param observedPinChars The observed PIN as a character array.
     * @param index            The current digit index being processed in the observed PIN.
     * @param currentPin       The StringBuilder holding the PIN being built.
     * @param possiblePins     The set to store all generated unique PINs.
     */
    private static void generatePins(char[] observedPinChars, int index, StringBuilder currentPin, Set<String> possiblePins) {
        // Base case: If all digits from the observed PIN have been processed
        if (index == observedPinChars.length) {
            possiblePins.add(currentPin.toString()); // Add the complete PIN to the set
            return;
        }

        char digit = observedPinChars[index]; // Get the current observed digit
        char[] adjacencies = ADJACENT_DIGITS.get(digit); // Get its adjacent digits

        // Iterate through each adjacent digit
        for (char adjacentDigit : adjacencies) {
            currentPin.append(adjacentDigit); // Append the adjacent digit to the current PIN
            // Recursively call for the next digit in the observed PIN
            generatePins(observedPinChars, index + 1, currentPin, possiblePins);
            currentPin.deleteCharAt(currentPin.length() - 1); // Backtrack: remove the last appended digit
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading input from STDIN
        String pin = br.readLine();

        // Call the solution method
        String[] result = solution(pin);

        // Print the result array
        for (String p : result) {
            System.out.println(p);
        }
    }
}
