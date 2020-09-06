import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * @author Lam
 * @date 2020/7/19
 */
public class P329LongestIncreasingPathInMatrix {
    /**
     * dp[i][j]表示以(i,j)为起点得到的最长递增路径
     */
    int[][] dp;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int result = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j);
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int curValue = matrix[row][col];
        int maxD = 0;


        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (isValid(nx, ny, matrix.length, matrix[0].length) && matrix[nx][ny] > curValue) {
                maxD = Math.max(maxD, dfs(matrix, nx, ny));
            }
        }

        dp[row][col] = maxD + 1;
        result = Math.max(result, dp[row][col]);
        return dp[row][col];
    }

    private boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public int longestIncreasingPath1(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int[][] outDegrees = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (isValid(nx, ny, m, n) && matrix[i][j] < matrix[nx][ny]) {
                        outDegrees[i][j]++;
                    }
                }

                // 初始化队列，加入出度为0的
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (isValid(nx, ny, m, n) && matrix[nx][ny] < matrix[x][y]) {
                        outDegrees[nx][ny]--;
                        if (outDegrees[nx][ny] == 0) {
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return ans;
    }

}
