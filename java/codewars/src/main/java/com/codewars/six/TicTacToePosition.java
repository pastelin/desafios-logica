package com.codewars.six;

import java.util.Arrays;

public class TicTacToePosition {

    /**
     * Verifies if the given Tic-Tac-Toe board represents a valid game position.
     *
     * @param board A 2D character array representing the board.
     * @return True if the position is valid, false otherwise.
     */
    public static boolean isValidPosition(char[][] board) {

        Arrays.asList(board).forEach(arrow -> System.out.println(Arrays.toString(arrow)));

        // Validate the board structure and content
        if (!isValidBoard(board)) {
            return false;
        }

        // Check if both players cannot win simultaneously
        if (isSomePlayerWinner(board, 'X') && isSomePlayerWinner(board, 'O')) {
            return false;
        }

        // Count occurrences of 'X' and 'O'
        int xCount = countOccurrences(board, 'X');
        int oCount = countOccurrences(board, 'O');

        if(isSomePlayerWinner(board, 'X')) {
            // If 'X' has won, it must have one more 'X' than 'O'
            return xCount == oCount + 1;
        } else if(isSomePlayerWinner(board, 'O')) {
            // If 'O' has won, the counts must be equal
            return xCount == oCount;
        } else {
            // If no one has won, the counts can differ by at most 1
            return xCount == oCount + 1 || xCount == oCount;

        }
    }

    /**
     * Validates the structure and content of the board.
     *
     * @param board A 2D character array representing the board.
     * @return True if the board is valid, false otherwise.
     */
    private static boolean isValidBoard(char[][] board) {
        if (board == null || board.length != 3) {
            return false;
        }

        for (char[] row : board) {
            if (row == null || row.length != 3) {
                return false;
            }
            for (char cell : row) {
                if (cell != 'X' && cell != 'O' && cell != '_') {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Checks if a given player has won the game.
     *
     * @param board  A 2D character array representing the board.
     * @param player The player ('X' or 'O') to check for a win.
     * @return True if the player has won, false otherwise.
     */
    public static boolean isSomePlayerWinner(char[][] board, char player) {
        return validatedBoardHorizontally(board, player) ||
                validatedBoardVertically(board, player) ||
                validatedBoardDiagonally(board, player);
    }

    /**
     * Checks for a horizontal win for the given player.
     */
    public static boolean validatedBoardHorizontally(char[][] board, char player) {
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a vertical win for the given player.
     */
    public static boolean validatedBoardVertically(char[][] board, char player) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a diagonal win for the given player.
     */
    public static boolean validatedBoardDiagonally(char[][] board, char player) {
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    /**
     * Counts the occurrences of a given player's symbol on the board.
     *
     * @param board  A 2D character array representing the board.
     * @param player The player ('X' or 'O') to count.
     * @return The number of occurrences of the player's symbol.
     */
    public static int countOccurrences(char[][] board, char player) {
        int count = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == player) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'_', 'X', 'O'},
                {'X', '_', '_'},
                {'X', 'O', 'O'},
        };

        System.out.println(isValidPosition(board)); // Expected output: true
    }


}
