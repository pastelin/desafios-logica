package com.codewars.six;

public class TakeTenMinutesWalk {

    public static boolean isValid(char[] walk) {
        if(walk.length != 10) return false;

        int x = 0, y = 0;

        for(char c : walk) {

            switch (c) {
                case 'n' -> y++;
                case 's' -> y--;
                case 'e' -> x++;
                case 'w' -> x--;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        char [] walk = {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
        System.out.println(isValid(walk));
    }
}
