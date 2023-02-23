package com.output.formatting;

public class OutputFormatting {

    public static String completarCadena(String cadena) {

        int longitudCadena = cadena.length();

        if (longitudCadena < 15) {

            for(int i = 0; i < 15 - longitudCadena; i++) {
                cadena = cadena.concat(" ");
            }

        }

        return cadena;
    }

    public static String completarNumero(int numero) {
        int numeroTemp = numero;
        int contador = 1;

        while (numeroTemp >= 10) {

            numeroTemp = numeroTemp / 10;
            contador++;
        }

        String nuevoNumero = "" + numero;

        if (contador < 3) {

            for(int i = 0; i < 3 - contador; i++) {

                nuevoNumero = "0".concat(nuevoNumero);

            }
        }

        return nuevoNumero;
    }


}
