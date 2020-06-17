package jzoffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 与leetcode p79相同
 *
 * @author Lam
 * @ClassName P12
 * @date 2020/6/17
 */
public class P12 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }

        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] == '.' || board[row][col] != word.charAt(idx)) {
            return false;
        }


        board[row][col] = '.';
        for (int i = 0; i < 4; i++) {
            if (dfs(board, row + dx[i], col + dy[i], word, idx + 1)) {
                return true;
            }
        }
        board[row][col] = word.charAt(idx);

        return false;
    }
}
