package com.output.formatting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una cadena");
        String cadena = scanner.next();

        System.out.println("Ingrese un numero");
        int numero = scanner.nextInt();

        System.out.println(OutputFormatting.completarCadena(cadena).length());

        System.out.println(OutputFormatting.completarNumero(numero));


    }

}
