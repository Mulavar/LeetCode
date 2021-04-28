/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
 * 并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class P130SurroundedRegions {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }

        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 扫描四条边界，不被 'X' 围绕的 'O' 一定与边界的 'O' 相连
        for (int i = 0; i < m; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                dfs(board, visited, m, n, i, 0);
            }

            if (!visited[i][n - 1] && board[i][n - 1] == 'O') {
                dfs(board, visited, m, n, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                dfs(board, visited, m, n, 0, i);
            }

            if (!visited[m - 1][i] && board[m - 1][i] == 'O') {
                dfs(board, visited, m, n, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, boolean[][] visited, int m, int n, int x, int y) {
        // 超出边界 或 之前扫描过
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || board[x][y] == 'X') {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(board, visited, m, n, nx, ny);
        }
    }
}
