import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author Lam
 * @date 2020/5/5
 */
public class P200NumberIslands {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n==0) {
            return 0;
        }
        int m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }

    //bfs：利用grid图本身的空间，不引入新的visited变量
    private void bfs(char[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        grid[x][y] = '0';
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
