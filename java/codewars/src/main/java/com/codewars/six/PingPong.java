package com.codewars.six;

/**
 * Simula un juego de ping-pong y determina el ganador basado en errores.
 *
 * La lógica del juego:
 * - Los jugadores golpean alternadamente ("ping" y "pong")
 * - Cualquier otro sonido ("bonk", "doof", etc.) es un error que termina el rally
 * - El jugador que NO cometió el último error gana el rally
 * - Se contabilizan los puntos de cada rally ganado
 * - En caso de empate en puntos, gana quien NO cometió el último error global
 *
 * Entrada: cadena con sonidos separados por "-"
 * Ejemplo: "ping-pong-ping-pong-bonk-bing-doof"
 * - rally 1: ping-pong-ping-pong (ping-pong-ping-pong), error "bonk"
 *   (pong es el último hit antes del error, ping es quien gana)
 *
 * @author Codewars Level 6
 */
public class PingPong {
    private static final String PING = "ping";
    private static final String PONG = "pong";

    /**
     * Determina el ganador del juego de ping-pong.
     *
     * Algoritmo:
     * 1. Divide la cadena de entrada por "-" para obtener tokens
     * 2. Itera sobre cada token:
     *    - Si es "ping" o "pong": lo registra como último golpe válido
     *    - Si es otro sonido: termina el rally actual
     * 3. Cuando termina un rally: gana quien golpeó y es diferente al servidor
     * 4. Al final, retorna el ganador general o el que no cometió el último error
     *
     * @param sounds cadena con sonidos separados por "-" (ej: "ping-pong-bonk-pong")
     * @return "ping" o "pong", indicando el ganador del juego
     */
    public static String pingPong(String sounds) {


        String[] tokens = sounds.split("-");

        int pingScore = 0;
        int pongScore = 0;

        String server = null;        // primer "ping"/"pong" del rally
        String lastPlayerHit = null; // último "ping"/"pong" antes del primer ruido malo
        String lastBadShotBy = null; // para desempate final

        for (String token : tokens) {
            if (isPlayer(token)) {
                if (server == null) server = token;
                lastPlayerHit = token;
                continue;
            }

            // token es ruido malo: termina el rally (si había rally activo)
            if (server != null) {
                lastBadShotBy = lastPlayerHit;

                String rallyWinner = otherPlayer(lastPlayerHit);
                if (rallyWinner.equals(server)) {
                    if (PING.equals(server)) pingScore++;
                    else pongScore++;
                }

                server = null;
                lastPlayerHit = null;
            }
        }

        if (pingScore != pongScore) {
            return pingScore > pongScore ? PING : PONG;
        }

        // empate: gana quien NO hizo el último mal golpe
        return PING.equals(lastBadShotBy) ? PONG : PING;
    }

    /**
     * Verifica si el token es un golpe válido de ping-pong.
     *
     * @param token el token a verificar
     * @return true si es "ping" o "pong", false en caso contrario
     */
    private static boolean isPlayer(String token) {
        return PING.equals(token) || PONG.equals(token);
    }

    /**
     * Retorna el jugador opuesto.
     *
     * @param player "ping" o "pong"
     * @return "pong" si el jugador es "ping", "ping" si el jugador es "pong"
     */
    private static String otherPlayer(String player) {
        return PING.equals(player) ? PONG : PING;
    }


    public static void main(String[] args) {
        System.out.println(pingPong("ping-pong-ping-pong-bonk-bing-doof"));
        System.out.println(pingPong("pong-ping-dong-ping-pong-tink-bonk-pong-ping-doof"));
        System.out.println(pingPong("pong-ping-bink-ping-pong-donk"));
    }

}
