package com.codewars.six;

public class SentenceCalculator {

    public static int lettersToNumbers(String s) {

        if (s == null) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z') {
                sum += (c - 'A' + 1) * 2;
            } else if (c >= '0' && c <= '9') {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static int lettersToNumberStream(String s) {
        if (s == null) return 0;

        return s.chars()
                .map(c -> c >= 'a' && c <= 'z' ? c - 'a' + 1 :
                        c >= 'A' && c <= 'Z' ? (c - 'A' + 1) * 2 :
                                c >= '0' && c <= '9' ? c - '0' : 0)
                .sum();
    }

    public static void main(String[] args) {
        String input = "ARE YOU HUNGRY?";
        int result = lettersToNumbers(input);
        System.out.println("The sum of letters and digits in the sentence is: " + result);
    }
}
