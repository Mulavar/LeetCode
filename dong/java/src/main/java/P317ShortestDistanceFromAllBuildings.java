import java.util.Arrays;
import java.util.LinkedList;

/**
 * 你是个房地产开发商，想要选择一片空地 建一栋大楼。
 * 你想把这栋大楼够造在一个距离周边设施都比较方便的地方，通过调研，你希望从它出发能在 最短的距离和 内抵达周边全部的建筑物。
 * 请你计算出这个最佳的选址到周边全部建筑物的 最短距离和。
 * 提示：
 * <p>
 * 你只能通过向上、下、左、右四个方向上移动。
 * 给你一个由 0、1 和 2 组成的二维网格，其中：
 * 0 代表你可以自由通过和选择建造的空地
 * 1 代表你无法通行的建筑物
 * 2 代表你无法通行的障碍物
 *
 * @author Lam
 * @date 2020/9/5
 */
public class P317ShortestDistanceFromAllBuildings {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return -1;
        }

        int n = grid[0].length;
        // dist[i][j] 建筑物到(i,j)的距离之和
        int[][] dist = new int[m][n];

        // note: LinkedList的push是栈的push
        LinkedList<int[]> queue = new LinkedList<>();

        // 空地到建筑物的最小距离
        int minDis = -1;

        // 记录BFS遍历次数的相反数，为负数
        // note: 为什么用相反数，因为grid里有1和2
        // note: 为什么不用visited数组，因为遍历次数有状态
        int times = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对每个建筑物做BFS
                // note: 为什么不用空地？因为无法保证每个空地都能到达所有建筑物
                if (grid[i][j] == 1) {
                    // 当前空地到建筑物的距离和
                    int curSumDis = Integer.MAX_VALUE;

                    // 当前BFS的层数
                    int curDis = 0;

                    queue.push(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        curDis++;

                        int size = queue.size();
                        for (int idx = 0; idx < size; idx++) {
                            int[] node = queue.poll();
                            int x = node[0];
                            int y = node[1];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (isValid(nx, ny, m, n, grid, times)) {
                                    // 更新该位置的遍历次数
                                    grid[nx][ny]--;

                                    // 更新建筑物到(nx, ny)的距离之和
                                    dist[nx][ny] += curDis;

                                    // 更新最小距离
                                    curSumDis = Math.min(dist[nx][ny], curSumDis);
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }

                    // 说明有个建筑物没能更新空地，即所有空地都无法到达该建筑物
                    if (curSumDis == Integer.MAX_VALUE) {
                        return -1;
                    }

                    times--;
                    minDis = curSumDis;

                }


            }
        }

        return minDis;
    }

    private boolean isValid(int row, int col, int m, int n, int[][] grid, int times) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == times;
    }

}
