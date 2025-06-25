package com.codewars.six;


import java.util.*;

public class Dinglemouse {

    public static void main(String[] args) {
        String in =
                "           \n" +
                        " a       b \n" +
                        " e         \n" +
                        "           \n" +
                        " d       c \n" +
                        "           \n";
        System.out.println(connectTheDots(in));

    }

    /**
     * Conecta los puntos en la cuadrícula en orden alfabético.
     *
     * @param paper La cuadrícula de entrada como una cadena.
     * @return La cuadrícula con los puntos conectados por líneas de asteriscos.
     */
    public static String connectTheDots(String paper) {
        // Dividir la entrada en líneas
        String[] lines = paper.split("\n");
        int rows = lines.length;
        int cols = lines[0].length();

        // Map para almacenar las posiciones de los puntos
        Map<Character, int[]> positions = locateDots(lines, rows, cols);

        // Ordenar los puntos alfabéticamente
        List<Character> dots = new ArrayList<>(positions.keySet());
        Collections.sort(dots);

        // Convertir la cuadrícula a un arreglo mutable de caracteres
        char[][] grid = convertToGrid(lines, rows, cols);

        // Conectar los puntos en orden
        connectDots(grid, dots, positions);

        // Reemplazar las letras por asteriscos
        replaceLettersWithAsterisks(grid, rows, cols);

        // Convertir la cuadrícula de vuelta a una cadena
        return convertGridToString(grid);
    }

    /**
     * Localiza los puntos etiquetados con letras en la cuadrícula.
     *
     * @param lines Las líneas de la cuadrícula.
     * @param rows  Número de filas.
     * @param cols  Número de columnas.
     * @return Un mapa con las posiciones de los puntos.
     */
    private static Map<Character, int[]> locateDots(String[] lines, int rows, int cols) {
        Map<Character, int[]> positions = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = lines[r].charAt(c);
                if (ch >= 'a' && ch <= 'z') {
                    positions.put(ch, new int[]{r, c});
                }
            }
        }
        return positions;
    }

    /**
     * Convierte las líneas de la cuadrícula en un arreglo mutable de caracteres.
     *
     * @param lines Las líneas de la cuadrícula.
     * @param rows  Número de filas.
     * @param cols  Número de columnas.
     * @return Una cuadrícula mutable como un arreglo bidimensional de caracteres.
     */
    private static char[][] convertToGrid(String[] lines, int rows, int cols) {
        char[][] grid = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            grid[r] = lines[r].toCharArray();
        }
        return grid;
    }

    /**
     * Conecta los puntos en la cuadrícula utilizando líneas de asteriscos.
     *
     * @param grid      La cuadrícula mutable.
     * @param dots      Lista de puntos en orden alfabético.
     * @param positions Mapa con las posiciones de los puntos.
     */
    private static void connectDots(char[][] grid, List<Character> dots, Map<Character, int[]> positions) {
        for (int i = 0; i < dots.size() - 1; i++) {
            int[] start = positions.get(dots.get(i));
            int[] end = positions.get(dots.get(i + 1));
            drawLine(grid, start, end);
        }
    }

    /**
     * Dibuja una línea recta entre dos puntos en la cuadrícula.
     *
     * @param grid  La cuadrícula mutable.
     * @param start Coordenadas del punto inicial.
     * @param end   Coordenadas del punto final.
     */
    private static void drawLine(char[][] grid, int[] start, int[] end) {
        int r1 = start[0], c1 = start[1];
        int r2 = end[0], c2 = end[1];

        int dr = Integer.compare(r2, r1); // Dirección para las filas
        int dc = Integer.compare(c2, c1); // Dirección para las columnas

        while (r1 != r2 || c1 != c2) {
            if (grid[r1][c1] == ' ') {
                grid[r1][c1] = '*';
            }
            r1 += dr;
            c1 += dc;
        }
        // Marcar el punto final
        if (grid[r2][c2] == ' ') {
            grid[r2][c2] = '*';
        }
    }

    /**
     * Reemplaza las letras en la cuadrícula por asteriscos.
     *
     * @param grid La cuadrícula mutable.
     * @param rows Número de filas.
     * @param cols Número de columnas.
     */
    private static void replaceLettersWithAsterisks(char[][] grid, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] >= 'a' && grid[r][c] <= 'z') {
                    grid[r][c] = '*';
                }
            }
        }
    }

    /**
     * Convierte la cuadrícula mutable en una cadena.
     *
     * @param grid La cuadrícula mutable.
     * @return La cuadrícula como una cadena.
     */
    private static String convertGridToString(char[][] grid) {
        StringBuilder result = new StringBuilder();
        for (char[] row : grid) {
            result.append(new String(row)).append("\n");
        }
        return result.toString();
    }
}
