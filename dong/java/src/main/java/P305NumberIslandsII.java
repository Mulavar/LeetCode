import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设你设计一个游戏，用一个 m 行 n 列的 2D 网格来存储你的游戏地图。
 * 起始的时候，每个格子的地形都被默认标记为「水」。我们可以通过使用 addLand 进行操作，将位置 (row, col) 的「水」变成「陆地」。
 * 你将会被给定一个列表，来记录所有需要被操作的位置，然后你需要返回计算出来 每次 addLand 操作后岛屿的数量。
 * 注意：一个岛的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
 *
 * @author Lam
 * @date 2020/8/26
 */
public class P305NumberIslandsII {
    int[] nextX = new int[]{0, 1, 0, -1};
    int[] nextY = new int[]{1, 0, -1, 0};

    int[] parent;

    private void newUnion(int n) {
        // 默认值为-1，表示是水
        parent = new int[n];
        Arrays.fill(parent, -1);
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//        }
    }

    private boolean union(int num1, int num2) {
        int r1 = find(num1);
        int r2 = find(num2);
        if (r1 == r2) {
            // 已经合并过，不必再合并
            return false;
        }

        // 合并
        parent[r1] = r2;
        return true;
    }

    private int find(int num) {
        int par = num;
        // 特殊处理-1的情况
        while (par != -1 && parent[par] != par) {
            par = parent[par];
        }

        if (par == -1) {
            return par;
        }

        while (parent[num] != num) {
            int tmp = parent[num];
            parent[num] = par;
            num = tmp;
        }

        return par;
    }

    /**
     * 并查集+二维转一维
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // 初始化
        newUnion(m * n);

        List<Integer> result = new ArrayList<>();

        // 目前岛屿数量
        int curAns = 0;

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];

            int island1 = x * n + y;
            if (find(island1) != -1) {
                // 该岛屿出现过
                result.add(curAns);
                continue;
            }

            // 标识该点不是水
            parent[island1] = island1;
            // 默认是孤岛
            curAns++;

            // 找邻接点
            for (int j = 0; j < 4; j++) {
                int nx = x + nextX[j];
                int ny = y + nextY[j];
                // 相邻点有岛屿，合并
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int island2 = nx * n + ny;
//                    System.out.println("合并" + island1 + ", " + island2);
                    if (parent[island2] != -1 && union(island1, island2)) {
                        // 合并成功
                        curAns--;
                    }
                }
            }

//            System.out.println(Arrays.toString(parent));
            result.add(curAns);
        }
        return result;
    }

}
