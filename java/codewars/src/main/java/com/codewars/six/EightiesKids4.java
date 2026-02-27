package com.codewars.six;

public class EightiesKids4 {

    public static String markSpot(float n) {
        if (n % 1 != 0) {
            return "?";
        }

        if(n < 1 || n % 2 == 0) {
            return "?";
        }

        if (n == 1) {
            return "X\n";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int d = (int) Math.min(i, n - 1 - i);
            sb.append(" ".repeat(2 * d));
            sb.append("X");
            if(i != (int) n/2) {
                int middleSpaces = (int) (2 * (n - 1 - 2 * d) - 1);
                sb.append(" ".repeat(middleSpaces));
                sb.append("X");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(markSpot(5));
    }
}
