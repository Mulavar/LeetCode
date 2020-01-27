/**
 * @author Lam
 * @ClassName P79WordSearch
 * @date 2020/1/27
 */
public class P79WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (solve(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean solve(char[][] board, String word, int rowCur, int colCur, int i) {
            if (i == word.length()) {
                return true;
            }

            char ch = word.charAt(i);
            if (rowCur < 0 || rowCur >= board.length || colCur < 0 || colCur >= board[0].length || board[rowCur][colCur] == '.' || board[rowCur][colCur] != ch) {
                return false;
            }

            board[rowCur][colCur] = '.';
            if (solve(board, word, rowCur, colCur + 1, i + 1)) {
                return true;
            }
            if (solve(board, word, rowCur, colCur - 1, i + 1)) {
                return true;
            }
            if (solve(board, word, rowCur + 1, colCur, i + 1)) {
                return true;
            }
            if (solve(board, word, rowCur - 1, colCur, i + 1)) {
                return true;
            }
            board[rowCur][colCur] = ch;
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        System.out.println(new P79WordSearch().new Solution().exist(board, "ABCCED"));
    }
}
