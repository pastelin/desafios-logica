package com.codewars.six;

public class JavaUnicodeEncoder {


    public static String decode(final String input) {
        StringBuilder sb = new StringBuilder();
        String[] parts = input.split("\\\\u");
        for (String part : parts) {
            if (!part.isEmpty()) {
                int codePoint = Integer.parseInt(part, 16);
                sb.append((char) codePoint);
            }
        }
        return sb.toString();
    }


    /*
    * (int) c: The character c is cast to its integer Unicode value. For example, the character 'a' has a Unicode value of 97.
    String.format("\\u%04x", ...):
    \\u: This is the prefix for Unicode escape sequences in Java.
    %04x: This is a format specifier:
    %04: Ensures the output is zero-padded to 4 digits.
    x: Converts the integer value to its hexadecimal representation.
    For example, if c is 'a', its Unicode value 97 is converted to 0061 in hexadecimal.
    *
    * */
    public static String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(String.format("\\u%04x", (int) c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char a = 'o';
        System.out.println(encode("hola"));
    }
}
