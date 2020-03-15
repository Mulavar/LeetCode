import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P289GameLife
 * @date 2020/2/5
 */
public class P289GameLife {
    class Solution {
        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    calcNext(board, i, j);
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 4) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        // live->die 4
        // die->live 3
        private void calcNext(int[][] board, int m, int n) {
            int[] x = {1, 1, 1, 0, 0, -1, -1, -1};
            int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
            int liveNeighbors = 0;
            for (int i = 0; i < x.length; i++) {
                int newM = m + x[i];
                int newN = n + y[i];
                if (newM < 0 || newM >= board.length) {
                    continue;
                }
                if (newN < 0 || newN >= board[0].length) {
                    continue;
                }
                if (board[newM][newN] == 1 || board[newM][newN] == 4) {
                    liveNeighbors++;
                }
            }
            if (board[m][n] == 1) {
                if ((liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[m][n] = 4;
                }
            } else {
                if (liveNeighbors == 3) {
                    board[m][n] = 3;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        new P289GameLife().new Solution().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
