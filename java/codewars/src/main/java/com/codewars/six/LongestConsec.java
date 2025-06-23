package com.codewars.six;

/*
* You are given an array(list) strarr of strings and an integer k.
* Your task is to return the first longest string consisting of k consecutive strings taken in the array.
* */
public class LongestConsec {

    // longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta")
    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0)
            return "";

        String longestStr = "";
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < strarr.length - k + 1; index++) {
            sb.setLength(0); // Reset the StringBuilder
            for (int i = index; i < index + k; i++) {
                sb.append(strarr[i]);
            }
            if (sb.length() > longestStr.length()) {
                longestStr = sb.toString();
            }
        }
        return longestStr;
    }
}
