package com.codewars.five;

import java.util.Arrays;

/**
 * Genera una matriz cuadrada NxN rellena con enteros consecutivos en forma de espiral
 * en sentido horario, comenzando en la esquina superior izquierda.
 *
 * <p>Ejemplo para N = 3:</p>
 * <pre>
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * </pre>
 *
 * <p>Complejidad: O(N^2) en tiempo y O(N^2) en memoria.</p>
 */
public class TheClockwiseSpiral {

    /**
     * Construye la espiral de tamaño N.
     *
     * @param N tamaño de la matriz cuadrada
     * @return matriz NxN en espiral; si N <= 0 retorna una matriz vacía (0x0)
     */
    public static int[][] createSpiral(int N) {

        if (N <= 0) {
            return new int[0][0];

        }

        // Límites de la "capa" actual que se está rellenando.
        int top = 0;
        int right = N - 1;
        int bottom = N - 1;
        int left = 0;
        int[][] spiral = new int[N][N];

        // Se incrementa antes de escribir para comenzar en 1.
        int number = 0;

        // Cada iteración completa rellena una capa: arriba, derecha, abajo e izquierda.
        while (top <= bottom && left <= right) {
            // 1) Recorrido de izquierda a derecha en la fila superior.
            for (int col = left; col <= right; col++) {
                number++;
                spiral[top][col] = number;
            }
            top++;

            // 2) Recorrido de arriba hacia abajo en la columna derecha.
            for (int row = top; row <= bottom; row++) {
                number++;
                spiral[row][right] = number;
            }
            right--;

            // 3) Recorrido de derecha a izquierda en la fila inferior.
            for (int col = right; col >= left; col--) {
                number++;
                spiral[bottom][col] = number;
            }

            bottom--;

            // 4) Recorrido de abajo hacia arriba en la columna izquierda.
            for (int row = bottom; row >= top; row--) {
                number++;
                spiral[row][left] = number;
            }
            left++;
        }

        return spiral;
    }

    /**
     * Ejecución rápida local para visualizar el resultado.
     */
    public static void main(String[] args) {
        int[][] spiral = createSpiral(5);
        System.out.println(Arrays.deepToString(spiral));
    }
}
