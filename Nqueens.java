public class NQueens {
    private int N;
    private int[] board;

    public NQueens(int N) {
        this.N = N;
        board = new int[N];
    }

    public void solve() {
        if (placeQueens(0)) {
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean placeQueens(int row) {
        if (row == N) {
            return true; // All queens are placed
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col; // Place queen
                if (placeQueens(row + 1)) {
                    return true; // Proceed to place next queen
                }
                // Backtrack
                board[row] = -1;
            }
        }
        return false; // Trigger backtracking
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check column and diagonal attacks
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4; // Change this value for different board sizes
        NQueens nQueens = new NQueens(N);
        nQueens.solve();
    }
}
