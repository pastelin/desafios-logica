package com.codewars.six;

public class ExpandedForm {

    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; num > 0; i *= 10) {
            int module = num % 10;
            num /= 10;
            if (module > 0) {
                result.insert(0, (num > 0 ? " + " : "") + module * i);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(70304));
    }
}
