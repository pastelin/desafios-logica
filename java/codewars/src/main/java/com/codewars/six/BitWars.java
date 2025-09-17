package com.codewars.six;

public class BitWars {

    public static String bitsWar(int[] numbers) {

        int sumOdds = 0; // Acumulador para la suma de los bits de los números impares
        int sumEvens = 0; // Acumulador para la suma de los bits de los números pares

        // Iterar sobre cada número en el arreglo
        for (int number : numbers) {
            // Convertir el valor absoluto del número a su representación binaria
            String binary = Integer.toBinaryString(Math.abs(number));
            int sumBits = 0; // Acumulador para la suma de los bits del número actual

            // Recorrer cada bit de la representación binaria
            for (int j = 0; j < binary.length(); j++) {
                // Si el número es positivo y el bit actual es '1', incrementar sumBits
                if (number > 0 && binary.charAt(j) == '1') {
                    sumBits++;
                }
                // Si el número es negativo y el bit actual es '1', decrementar sumBits
                else if (number < 0 && binary.charAt(j) == '1') {
                    sumBits--;
                }
            }

            // Verificar si el número es impar o par y actualizar el acumulador correspondiente
            if (number % 2 != 0) {
                sumOdds += sumBits; // Sumar a los impares
            } else {
                sumEvens += sumBits; // Sumar a los pares
            }
        }

        // Determinar el resultado de la "batalla" entre impares y pares
        return sumOdds > sumEvens ? "odds win" : sumEvens > sumOdds ? "evens win" : "tie";
    }

    public static void main(String[] args) {
        System.out.println(bitsWar(new int[]{1, 5, 12}));
        System.out.println(bitsWar(new int[]{7, -3, 20}));
        System.out.println(bitsWar(new int[]{7, -3, -2, 6}));
    }
}
