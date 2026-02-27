package com.codewars.six;

public class KillerGarageDoor {

    public static String run(String events) {
        StringBuilder result = new StringBuilder();
        boolean isFullyOpen = false;
        boolean isOrderedToOpen = true;
        boolean isAnObstacleDetected = false;
        int openCount = 0;
        int timesButtonPressed = 0;

        char[] eventArray = events.toCharArray();

        for (char event : eventArray) {
            if (event == 'P') {
                timesButtonPressed++;
            } else if (event == 'O') {
                isAnObstacleDetected = true;
            }

            if (timesButtonPressed == 3) {
                timesButtonPressed = 1;
            }

            if (event == 'P' && isOrderedToOpen && timesButtonPressed == 1 && !isAnObstacleDetected) {
                openCount++;
                result.append(openCount);
            } else if (event == 'P' && !isOrderedToOpen && timesButtonPressed == 1 && !isAnObstacleDetected) {
                openCount--;
                result.append(openCount);
                if (isFullyOpen) {
                    isFullyOpen = false;
                }
            } else if (event == '.' && timesButtonPressed == 1 && !isAnObstacleDetected && isOrderedToOpen) {
                openCount++;
                result.append(openCount);
            } else if (event == '.' && timesButtonPressed == 1 && !isAnObstacleDetected) {
                openCount--;
                result.append(openCount);
            } else if (isAnObstacleDetected && isOrderedToOpen && timesButtonPressed == 1) {
                openCount--;
                result.append(openCount);
            } else if (isAnObstacleDetected && !isOrderedToOpen && !isFullyOpen && timesButtonPressed == 1) {
                openCount++;
                result.append(openCount);
            } else {
                result.append(openCount);
            }

            if (isOrderedToOpen && openCount == 5) {
                isOrderedToOpen = false;
                isFullyOpen = true;
                timesButtonPressed = 0;
            } else if (isOrderedToOpen && isAnObstacleDetected && openCount == 0) {
                isAnObstacleDetected = false;
                timesButtonPressed = 0;
            } else if (!isOrderedToOpen && isAnObstacleDetected && openCount == 5) {
                isFullyOpen = false;
                isAnObstacleDetected = false;
                timesButtonPressed = 0;

            } else if (!isOrderedToOpen && openCount == 0) {
                isOrderedToOpen = true;
                timesButtonPressed = 0;
            }

        }

        return result.toString();
    }


    public enum State {
        OPENING,
        CLOSING,
        OPEN,
        CLOSED,
        PAUSED_OPENING,
        PAUSED_CLOSING
    }

    public static String runOptimized(String events) {
        StringBuilder result = new StringBuilder();
        State currentState = State.CLOSED;
        int position = 0; // Posición inicial de la puerta (0 = cerrada, 5 = abierta)
        for (char event : events.toCharArray()) {


            // 'event' es el char actual
            switch (currentState) {
                case CLOSED:
                    if (event == 'P') {
                        position++; // Comienza a abrir
                        currentState = State.OPENING; // Cambia de estado
                    }
                    // Si el evento es '.' o 'O', no hace nada.
                    break;

                case OPENING:
                    if (event == 'O') {
                        currentState = State.CLOSING; // Obstáculo: reversa
                        position--;
                    } else if (event == 'P') {
                        currentState = State.PAUSED_OPENING; // Pausa
                    } else { // El evento es '.'
                        position++; // Sigue abriendo
                        if (position == 5) {
                            currentState = State.OPEN; // Llegó al final
                        }
                    }
                    break;

                case OPEN:
                    if (event == 'P') {
                        position--; // Comienza a cerrar
                        currentState = State.CLOSING; // Cierra
                    }
                    // Si es '.' o 'O', no hace nada
                    break;

                case CLOSING:
                    if (event == 'O') {
                        position++; // Avanza
                        currentState = State.OPENING; // Obstáculo: reversa
                    } else if (event == 'P') {
                        currentState = State.PAUSED_CLOSING; // Pausa
                    } else { // El evento es '.'
                        position--; // Sigue cerrando
                        if (position == 0) {
                            currentState = State.CLOSED; // Llegó al final
                        }
                    }
                    break;
                case PAUSED_OPENING:
                    if (event == 'P') {
                        currentState = State.OPENING; // Reanuda apertura
                        position++; // Sigue abriendo
                    } else if (event == 'O') {
                        position--; // Retrocede
                        currentState = State.CLOSING; // Obstáculo: reversa
                    }
                    break;
                case PAUSED_CLOSING:
                    if (event == 'P') {
                        currentState = State.CLOSING; // Reanuda cierre
                        position--; // Sigue cerrando
                    } else if (event == 'O') {
                        position++; // Avanza
                        currentState = State.OPENING; // Obstáculo: reversa
                    }
                    break;

            }
            result.append(position);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(run("P......P.O...."));
        System.out.println(runOptimized("P..OP..P.."));
        System.out.println(run("P..OP..P.."));
    }
}
