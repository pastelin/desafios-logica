package com.baires.dev.comment_section;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SeatReservation {

    public static int[] solutionMe(int N, int K, int[] seat) {

        int countOfReservedSeats = 0;

        for (int i = 0; i < K; i++) {
            if (seat[i] == 0) {
                countOfReservedSeats++;
            }
        }

        int[] reservedSeats = new int[countOfReservedSeats];
        int[] numberOfReservedSeats = new int[countOfReservedSeats];
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (seat[i] == 0) {
                int smallestUnreservedSeat = 0;

                for (int j = 0; j < reservedSeats.length; j++) {
                    if (smallestUnreservedSeat < reservedSeats[j]) {
                        smallestUnreservedSeat = reservedSeats[j];
                    }
                }

                for (int j = 0; j < reservedSeats.length; j++) {
                    if (reservedSeats[j] == 0) {
                        reservedSeats[j] = smallestUnreservedSeat + 1;
                        numberOfReservedSeats[count] = smallestUnreservedSeat + 1; // Guardamos el número de reserva
                        count++;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < reservedSeats.length; j++) {
                    if (seat[i] == reservedSeats[j]) {
                        reservedSeats[j] = 0; // Si el asiento está reservado, lo marcamos como 0
                        break;
                    }
                }
            }

        }
        return numberOfReservedSeats;
    }


    /**
     * Resuelve el problema de reserva de asientos.
     *
     * @param N El número total de asientos (de 1 a N).
     * @param K El número de operaciones a realizar.
     * @param seat Un array de enteros que describe las K operaciones.
     * @return Una lista de enteros con los números de los asientos reservados.
     */
    public static int[] solution(int N, int K, int[] seat) {
        // PriorityQueue para mantener los asientos disponibles.
        // Automáticamente nos dará el asiento con el número más bajo.
        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            availableSeats.add(i);
        }

        // Lista para almacenar los resultados de las operaciones de reserva.
        List<Integer> result = new ArrayList<>();

        // Procesar cada una de las K operaciones.
        for (int operation : seat) {
            if (operation == 0) {
                // --- Operación de RESERVA ---
                // Obtener el asiento disponible con el número más pequeño.
                // poll() recupera y elimina la cabeza de la cola (el elemento más pequeño).
                if (!availableSeats.isEmpty()) {
                    int reservedSeat = availableSeats.poll();
                    result.add(reservedSeat);
                }
            } else {
                // --- Operación de CANCELACIÓN ---
                // 'operation' contiene el número del asiento a cancelar.
                // Lo devolvemos a la cola de asientos disponibles.
                availableSeats.add(operation);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        int[] solution = solution(5, 12, new int[]{0, 0, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1});

        System.out.print("Reserved Seats: ");
        for (int seat : solution) {
            System.out.print(seat + " ");
        }
    }


}
