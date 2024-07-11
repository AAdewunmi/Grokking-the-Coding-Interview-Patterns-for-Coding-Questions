package Backtracking;

// Problem Statement: Sudoku Solver (hard)
// LeetCode Question: 37. Sudoku Solver

public class Problem_3_Sudoku_Solver {

    public boolean solveSudoku (char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, (char) (num + '0'))) {
                            board[row][col] = (char) (num + '0');
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid (char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
