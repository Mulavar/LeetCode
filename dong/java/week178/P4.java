package week178;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m x n 的网格图 grid 。 grid 中每个格子都有一个数字，对应着从该格子出发下一步走的方向。 grid[i][j] 中的数字可能为以下几种情况：
 * <p>
 * 1 ，下一步往右走，也就是你会从 grid[i][j] 走到 grid[i][j + 1]
 * 2 ，下一步往左走，也就是你会从 grid[i][j] 走到 grid[i][j - 1]
 * 3 ，下一步往下走，也就是你会从 grid[i][j] 走到 grid[i + 1][j]
 * 4 ，下一步往上走，也就是你会从 grid[i][j] 走到 grid[i - 1][j]
 * 注意网格图中可能会有 无效数字 ，因为它们可能指向 grid 以外的区域。
 * 一开始，你会从最左上角的格子 (0,0) 出发。我们定义一条 有效路径 为从格子 (0,0) 出发，每一步都顺着数字对应方向走，最终在最右下角的格子 (m - 1, n - 1) 结束的路径。有效路径 不需要是最短路径 。
 * 你可以花费 cost = 1 的代价修改一个格子中的数字，但每个格子中的数字 只能修改一次 。
 * 请你返回让网格图至少有一条有效路径的最小代价。
 *
 * @author Lam
 * @ClassName P4
 * @date 2020/3/1
 */
public class P4 {
    int[] moveX = new int[]{0, 0, 0, 1, -1};
    int[] moveY = new int[]{0, 1, -1, 0, 0};

    /**
     * bfs思想，第i轮找cost i能到达的所有点
     */
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        queue.offer(new Node(0, 0));
        next.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int idx = grid[node.x][node.y];

            if (idx == -1) {
                // 换个方向走
                for (int i = 1; i <= 4; i++) {
                    int newX = node.x + moveX[i];
                    int newY = node.y + moveY[i];
                    while (isValid(newX, newY, m, n) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        next.offer(new Node(newX, newY));
                        int newIdx = grid[newX][newY];
                        newX += moveX[newIdx];
                        newY += moveY[newIdx];
                    }
                }
            } else {
                // 一次走完
                int newX = node.x + moveX[idx];
                int newY = node.y + moveY[idx];
                while (isValid(newX, newY, m, n) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    next.offer(new Node(newX, newY));
                    int newIdx = grid[newX][newY];
                    System.out.println("newIdX:" + newIdx);
                    System.out.println(Arrays.deepToString(grid));
                    newX += moveX[newIdx];
                    newY += moveY[newIdx];

                }
            }

            while (queue.isEmpty() && !next.isEmpty()) {
                while (!next.isEmpty()) {
                    Node tmp = next.poll();
                    if (tmp.x == m - 1 && tmp.y == n - 1) {
                        return cost;
                    }
                    grid[tmp.x][tmp.y] = -1;
                    queue.offer(tmp);
                }
                cost++;
            }


        }

        return cost;
    }

    /**
     * bfs精简版
     */
    public int minCost1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cost = 0;
        // 如果用bool数组，无法区分是用了几次cost走到的
//        boolean[][] visited = new boolean[m][n];
        int[][] visited = new int[m][n];
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        queue.offer(new Node(0, 0));
        for (int i = 0; i < m; i++) {
            // 初始化保证每个节点都能被访问到
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!queue.isEmpty() || !next.isEmpty()) {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (visited[node.x][node.y] < cost) {
                    continue;
                }
                if (node.x == m - 1 && node.y == n - 1) {
                    return cost;
                }
                for (int i = 1; i <= 4; i++) {
                    int nX = node.x + moveX[i];
                    int nY = node.y + moveY[i];
                    // < cost 表示这是上一轮就走到了
                    if (!isValid(nX, nY, m, n) || visited[nX][nY] <= cost) {
                        continue;
                    }

                    if (i == grid[node.x][node.y]) {
                        queue.offer(new Node(nX, nY));
                        visited[nX][nY] = cost;
                    } else {
                        next.offer(new Node(nX, nY));
                        visited[nX][nY] = cost + 1;
                    }
                }
            }
            queue = next;
            next = new LinkedList<>();
            cost++;
        }

        return cost;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        System.out.println(new P4().minCost1(grid));
    }
}
