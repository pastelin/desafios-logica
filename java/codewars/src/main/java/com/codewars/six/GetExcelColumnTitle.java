package com.codewars.six;

/**
 * Utilidad para convertir un número entero positivo en su correspondiente título de columna de Excel.
 * Por ejemplo: 1 -> "A", 27 -> "AA", 703 -> "AAA".
 */
public class GetExcelColumnTitle {

    // Constantes para el cálculo de letras
    private static final int ALPHABET_LENGTH = 26;
    private static final char FIRST_LETTER = 'A';

    /**
     * Convierte un número entero positivo en el título de columna de Excel correspondiente.
     *
     * @param num Número entero positivo (debe ser mayor o igual a 1).
     * @return Título de columna de Excel como String.
     * @throws IllegalArgumentException si el número es menor que 1.
     */
    public static String getColumnTitle(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("El número de entrada debe ser un entero positivo mayor o igual a 1.");
        }

        StringBuilder columnTitle = new StringBuilder();
        // Algoritmo para convertir el número a título de columna de Excel
        while (num > 0) {
            num--; // Ajuste para que 1 corresponda a 'A'
            char letter = (char) (FIRST_LETTER + (num % ALPHABET_LENGTH));
            columnTitle.insert(0, letter); // Insertar al inicio para construir el título correctamente
            num /= ALPHABET_LENGTH;
        }

        return columnTitle.toString();
    }

    /**
     * Método principal para pruebas rápidas.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println(getColumnTitle(1));   // "A"
        System.out.println(getColumnTitle(26));  // "Z"
        System.out.println(getColumnTitle(27));  // "AA"
        System.out.println(getColumnTitle(52));  // "AZ"
        System.out.println(getColumnTitle(703)); // "AAA"
    }

}
