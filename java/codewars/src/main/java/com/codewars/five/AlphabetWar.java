package com.codewars.five;

public class AlphabetWar {

    public static String woLoLoooooo(String battlefield) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < battlefield.length(); i++) {
            char vecinoIzq = (i > 0) ? battlefield.charAt(i - 1) : ' ';
            char vecinoDer = (i < battlefield.length() - 1) ? battlefield.charAt(i + 1) : ' ';
            char c = battlefield.charAt(i);

            sb.append(transformarCharacter(c, vecinoIzq, vecinoDer));
        }

        int acumulacion = 0;
        for (int i = 0; i < sb.length(); i++) {
            switch (sb.charAt(i)) {
                case 'w':
                    acumulacion += 4;
                    break;
                case 'p':
                    acumulacion += 3;
                    break;
                case 'b':
                    acumulacion += 2;
                    break;
                case 's':
                    acumulacion += 1;
                    break;
                case 'm':
                    acumulacion -= 4;
                    break;
                case 'q':
                    acumulacion -= 3;
                    break;
                case 'd':
                    acumulacion -= 2;
                    break;
                case 'z':
                    acumulacion -= 1;
                    break;
            }
        }

        // Your code here!
        return acumulacion > 0 ? "Left side wins!" : acumulacion < 0 ? "Right side wins!" : "Let's fight again!";
    }

    private static char transformarCharacter(char c, char vecinoIzq, char vecinoDer) {

        boolean sacerdoteT = (vecinoIzq == 't' || vecinoDer == 't') && (vecinoIzq != 'j' && vecinoDer != 'j');
        boolean sacerdoteJ = (vecinoIzq == 'j' || vecinoDer == 'j') && (vecinoIzq != 't' && vecinoDer != 't');

        switch (c) {
            case 'w':
                if (sacerdoteJ) return 'm';
                break;
            case 'p':
                if (sacerdoteJ) return 'q';
                break;
            case 'b':
                if (sacerdoteJ) return 'd';
                break;
            case 's':
                if (sacerdoteJ) return 'z';
                break;
            case 'm':
                if (sacerdoteT) return 'w';
                break;
            case 'q':
                if (sacerdoteT) return 'p';
                break;
            case 'd':
                if (sacerdoteT) return 'b';
                break;
            case 'z':
                if (sacerdoteT) return 's';
                break;

        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(woLoLoooooo("z"));
        System.out.println(woLoLoooooo("zdqmwpbs"));
        System.out.println(woLoLoooooo("zdqmwpbst"));
        System.out.println(woLoLoooooo("zdqmwpbsj"));
        System.out.println(woLoLoooooo("zdqmwpbstj"));
    }
}
