package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * @author Lam
 * @date 2020/7/1
 */
public class P13 {
    private int[] dx = {1, 0};
    private int[] dy = {0, 1};

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int result = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i=0;i<2;i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx>=m||ny>=n||calcDigit(nx)+calcDigit(ny)>k||visited[nx][ny]) {
                    continue;
                }

                queue.add(new Node(nx, ny));
                visited[nx][ny] = true;
                result++;
            }
        }
        return result;
    }

    private int calcDigit(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x /= 10;
        }
        return result;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
