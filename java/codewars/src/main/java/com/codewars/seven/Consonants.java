package com.codewars.seven;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Consonants {

    public static int getCount(String str) {
        String regex = "[a-zA-Z]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        char[] letters = str.toCharArray();
        int index = 0;

        for(int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);
            Matcher matcher = pattern.matcher(letter);

            if(matcher.find() && !("aeiou").contains(String.valueOf(letters[i]))) {
                index++;
            }
        }

        return index;
    }

    public static int getCountOptimized(String str) {
        String regex = "[a-zA-Z]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        return (int) str.chars()
                .mapToObj(i -> (char) i)
                .filter((letter) -> {
                    String letterStr = String.valueOf(letter);
                    Matcher matcher = pattern.matcher(letterStr);
                    return matcher.find() && !("aeiou").contains(letterStr);
                })
                .count();
    }

    public static int getCountRefactorized(final String str) {
        return str.replaceAll("(?i)[aeiou\\d\\W_]", "").length();
    }

}
