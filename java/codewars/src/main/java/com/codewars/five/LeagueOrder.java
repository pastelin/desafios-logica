package com.codewars.five;

/**
 * Calcula el ranking de equipos en una liga deportiva.
 *
 * Reglas de puntuación:
 * - Victoria: 2 puntos
 * - Empate: 1 punto
 * - Derrota: 0 puntos
 *
 * Criterios de ordenamiento (en orden de prioridad):
 * 1. Puntos totales (mayor primero)
 * 2. Diferencia de goles (mayor primero)
 * 3. Goles a favor (mayor primero)
 *
 * Desempates: Si dos equipos están completamente empatados en todos los criterios,
 * comparten el mismo rango.
 *
 * Estructura de datos (array de 6 elementos por equipo):
 * - [0] ID del equipo
 * - [1] Goles a favor
 * - [2] Goles en contra
 * - [3] Diferencia de goles (a favor - en contra)
 * - [4] Puntos totales
 * - [5] Rango final
 *
 * @author Codewars Level 5
 */
public class LeagueOrder {

    /**
     * Computa y retorna el ranking de cada equipo.
     *
     * Algoritmo:
     * 1. Inicializa array de puntos para cada equipo (6 columnas)
     * 2. Procesa cada partida:
     *    - Calcula puntos para el equipo 1
     *    - Calcula puntos para el equipo 2
     * 3. Ordena equipos por criterios de clasificación
     * 4. Asigna rangos (considerando desempates)
     * 5. Retorna array de rangos por ID de equipo original
     *
     * Ejemplo:
     * Entrada:
     *   8 equipos
     *   Partida: equipo 0 vs equipo 7, goles 2-0
     *
     * Salida:
     *   [1, 2, 3, 4, 5, 6, 7, 8] (o similar según otras partidas)
     *
     * Complejidad temporal: O(g log t) donde g = cantidad de partidas, t = cantidad de equipos
     * Complejidad espacial: O(t) para almacenar puntos de los equipos
     *
     * @param number cantidad total de equipos en la liga
     * @param games array de partidas, cada una con [team1, team2, goals1, goals2]
     * @return array con el rango de cada equipo (índice = ID equipo, valor = rango)
     */
    public static int[] computeRanks(int number, int[][] games) {
        // Inicializa array de puntos: 6 columnas por equipo
        int[][] points = new int[number][6];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = i; // Almacena el ID del equipo
        }

        // Procesa cada partida
        for (int[] game : games) {
            int team1 = game[0], team2 = game[1], goals1 = game[2], goals2 = game[3];

            // Calcula puntos para team1 (victoria=2, empate=1, derrota=0)
            updatePoints(points, team1, goals1, goals2,
                goals1 > goals2 ? 2 : goals1 == goals2 ? 1 : 0);

            // Calcula puntos para team2
            updatePoints(points, team2, goals2, goals1,
                goals2 > goals1 ? 2 : goals2 == goals1 ? 1 : 0);
        }

        // Ordena equipos por criterios de clasificación:
        // 1. Puntos (descending)
        // 2. Diferencia de goles (descending)
        // 3. Goles a favor (descending)
        java.util.Arrays.sort(points, (a, b) ->
            b[4] != a[4] ? b[4] - a[4]           // Comparar puntos
            : b[3] != a[3] ? b[3] - a[3]         // Comparar diferencia de goles
            : b[1] - a[1]                        // Comparar goles a favor
        );

        // Asigna rangos, considerando desempates
        int rank = 1, prevRank = 1;
        int prevSum = points[0][4] + points[0][3];  // Puntos + diferencia
        int prevGoals = points[0][1];                // Goles a favor

        for (int i = 0; i < points.length; i++) {
            int currentSum = points[i][4] + points[i][3];
            int currentGoals = points[i][1];

            if (i > 0 && prevSum == currentSum && prevGoals == currentGoals) {
                // Mismo rango que el equipo anterior (desempate total)
                points[i][5] = prevRank;
            } else {
                // Nuevo rango
                prevRank = rank;
                points[i][5] = rank;
            }

            prevSum = currentSum;
            prevGoals = currentGoals;
            rank++;
        }

        // Retorna array de rangos por ID de equipo original
        int[] teams = new int[points.length];
        for (int[] point : points) {
            teams[point[0]] = point[5];  // points[0] = ID original, points[5] = rango
        }

        return teams;
    }

    /**
     * Actualiza los puntos de un equipo después de una partida.
     *
     * Actualiza:
     * - Goles a favor (columna 1)
     * - Goles en contra (columna 2)
     * - Diferencia de goles (columna 3)
     * - Puntos totales (columna 4)
     *
     * @param points matriz de puntos de todos los equipos
     * @param team ID del equipo a actualizar
     * @param goalsFor goles que metió el equipo
     * @param goalsAgainst goles que recibió el equipo
     * @param pointsForMatch puntos obtenidos en la partida (0, 1, o 2)
     */
    private static void updatePoints(int[][] points, int team, int goalsFor, int goalsAgainst, int pointsForMatch) {
        points[team][0] = team;                              // ID equipo
        points[team][1] += goalsFor;                        // Goles a favor
        points[team][2] += goalsAgainst;                    // Goles en contra
        points[team][3] += goalsFor - goalsAgainst;         // Diferencia
        points[team][4] += pointsForMatch;                  // Puntos totales
    }

    /**
     * Método main para pruebas.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int [] result = computeRanks(8, new int[][]{{0, 7, 2, 0}});
        for (int i : result) {
            System.out.println(i);
        }
    }
}