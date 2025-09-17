package com.codewars;

public class Main {

    public static String getCode(String pCadena) {
        int i = 0;
        String strBuscado = "";
        int val = 0;
        StringBuffer strValor = new StringBuffer();
        StringBuffer paso = new StringBuffer(pCadena.toLowerCase());

        for (i = paso.length() - 1; i >= 0; i -= 3) {
            strBuscado = paso.substring(i - 2);
            paso.delete(i - 2, i + 1);
            val = Integer.parseInt(strBuscado, 16);
            strValor.append((char) (val - 51));
        }
        return strValor.toString();
    }

    public static void main(String[] args) {

        System.out.println("USER");
        System.out.println(getCode("09B0960A70940950A20AB098"));

        System.out.println("PASSWORD");
        System.out.println(getCode("07906306507506506706906506706B06A095064099097098"));

        System.out.println("DB URL");
        System.out.println(getCode("0A30960A70920940A509509C09F07008507808908507808608B07C08008508207908107C06D0970A20A00960A109809209509706206806506806406D06406706406106806306506106306306406106306806406206206D09C09F0A40A60600AB09C0A00A50A20990A109C06D09609509709D"));
    }
}
