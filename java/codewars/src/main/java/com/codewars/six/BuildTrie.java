package com.codewars.six;

import java.util.HashMap;
import java.util.Map;

public class BuildTrie {

    /**
     * Builds a Trie (prefix tree) from a list of words using nested HashMaps.
     *
     * @param words A variable number of strings to be added to the Trie.
     * @return A nested Map representing the Trie structure.
     */
    public static Map<String, Object> buildTrie(String... words) {
        // Start with an empty root map. This will be the final result.
        Map<String, Object> root = new HashMap<>();

        // If there are no words, return the empty map as per the requirements.
        if (words == null) {
            return root;
        }

        // Process each word one by one.
        for (String word : words) {
            // For each word, we start our traversal from the root of the Trie.
            Map<String, Object> currentMap = root;

            // Loop through the word to generate all its prefixes.
            // e.g., for "tea", prefixes are "t", "te", "tea".
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);

                // Check if this is the last prefix (i.e., the full word).
                if (i == word.length()) {
                    // This is the end of a word. We place the prefix as a key
                    // and 'null' as its value.
                    // putIfAbsent prevents overwriting a map if a shorter word
                    // is added after a longer one (e.g., "tea" then "te").
                    currentMap.putIfAbsent(prefix, null);
                } else {
                    // This is an intermediate prefix, not the end of the word.
                    // We need to ensure a map exists for this prefix so we can dive deeper.
                    // 'computeIfAbsent' is a clean way to do this:
                    // - If the 'prefix' key exists, it does nothing.
                    // - If it doesn't exist, it creates a new HashMap, adds it to the map,
                    //   and returns it.
                    currentMap.computeIfAbsent(prefix, k -> new HashMap<>());

                    // Move our reference down to the next level (the inner map).
                    currentMap = (Map<String, Object>) currentMap.get(prefix);
                }
            }
        }

        return root;
    }

    /**
     * Main method for demonstration and testing.
     */
    public static void main(String[] args) {
        System.out.println("trie: " + buildTrie("trie"));
        // Expected: {t={tr={tri={trie=null}}}}

        System.out.println("A, to, tea...: " + buildTrie("A", "to", "tea", "ted", "ten", "i", "in", "inn"));
        // Expected: {A=null, t={te={tea=null, ted=null, ten=null}, to=null}, i={in={inn=null}}}

        System.out.println("true, trust: " + buildTrie("true", "trust"));
        // Expected: {t={tr={tru={true=null, trus={trust=null}}}}}

        System.out.println("Empty: " + buildTrie());
        // Expected: {}
    }

}
