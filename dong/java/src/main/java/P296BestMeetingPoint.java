import java.util.ArrayList;
import java.util.List;

/**
 * 有一队人（两人或以上）想要在一个地方碰面，他们希望能够最小化他们的总行走距离。
 * 给你一个 2D 网格，其中各个格子内的值要么是 0，要么是 1。
 * 1 表示某个人的家所处的位置。这里，我们将使用 曼哈顿距离 来计算，其中 distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|。
 *
 * @author Lam
 * @date 2020/7/24
 */
public class P296BestMeetingPoint {
    /**
     * 曼哈顿距离，可分隔成独立的一维子问题
     */
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        // 按序收集x（列）
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) {
                    cols.add(i);
                }
            }
        }

        // 按序收集y（行）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }

        return calculate(rows) + calculate(cols);
    }

    private int calculate(List<Integer> lists) {
        int left = 0;
        int right = lists.size() - 1;
        int result = 0;

        while (left<right) {
            result += (lists.get(right--) - lists.get(left++));
        }

        return result;
    }
}
