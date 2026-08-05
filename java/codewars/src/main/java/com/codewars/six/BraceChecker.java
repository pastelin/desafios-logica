package com.codewars.six;

import java.util.ArrayList;

public class BraceChecker {

    public boolean isValid(String braces) {
        // Add code here
        ArrayList<Character> bracesList = new ArrayList<>();
        for (char c : braces.toCharArray()) {
            switch (c) {
                case '(':
                    bracesList.add(')');
                    break;
                case '{':
                    bracesList.add('}');
                    break;
                case '[':
                    bracesList.add(']');
                    break;
                default:
                    if (bracesList.isEmpty() || bracesList.get(bracesList.size() - 1) != c) {
                        return false;
                    }
                    bracesList.remove(bracesList.size() - 1);
            }
        }
        return bracesList.isEmpty();
    }

    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker();
        System.out.println(braceChecker.isValid("()")); // true
//        System.out.println(braceChecker.isValid("([{}])")); // true
//        System.out.println(braceChecker.isValid("(}")); // false
//        System.out.println(braceChecker.isValid("[(])")); // false
//        System.out.println(braceChecker.isValid("[({})](]")); // false
    }

}
