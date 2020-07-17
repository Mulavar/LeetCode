import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * @author Lam
 * @date 2020/7/17
 */
public class P52NQueensII {
    int result = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return result;
        }

        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(i);
        }

        // 不能用布尔，因为可能有重叠访问到的格子
        int[][] visited = new int[n][n];
        backtrack(rows, visited, 0, n);

        return result;
    }

    private void backtrack(List<Integer> rows, int[][] visited, int curCol, int n) {
        if (curCol >= n) {
            result++;
            return;
        }

        for (int i = 0; i < rows.size(); i++) {
            int row = rows.remove(i);

            if (visited[row][curCol] == 0) {
                for (int j = row, k = curCol; j < n && k < n; j++, k++) {
                    visited[j][k]++;
                }

                for (int j = row - 1, k = curCol + 1; j >= 0 && k < n; j--, k++) {
                    visited[j][k]++;
                }

                backtrack(rows, visited, curCol + 1, n);

                for (int j = row, k = curCol; j < n && k < n; j++, k++) {
                    visited[j][k]--;
                }

                for (int j = row - 1, k = curCol + 1; j >= 0 && k < n; j--, k++) {
                    visited[j][k]--;
                }
            }

            rows.add(i, row);
        }
    }
}
