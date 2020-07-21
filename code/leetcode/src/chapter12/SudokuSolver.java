package chapter12;

class SudokuSolver {

    //sudoku-solver
    //解法1
    //https://leetcode.com/problems/sudoku-solver/discuss/15911/Less-than-30-line-clean-java-solution-using-DFS
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            //check row
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            //check column
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            //check 3*3 block
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
            board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }


}