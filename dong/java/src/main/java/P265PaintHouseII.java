/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 *
 * @author Lam
 * @date 2020/7/22
 */
public class P265PaintHouseII {
    public int minCostII(int[][] costs) {
        // 当前行刷墙颜色->刷墙花费 的映射
        // 只需要记录花费最小的两个刷墙方式
        int minIdx = -1;
        int minValue = 0;
        int minSecondValue = 0;

        int n = costs.length;
        if (n == 0) {
            return 0;
        }

        int k = costs[0].length;

        for (int i = 0; i < n; i++) {
            int curMinIdx = -1;
            int curMinValue = Integer.MAX_VALUE;
            int curMinSecondValue = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                int curCost = costs[i][j];
                // 加最小的
                if (j != minIdx) {
                    curCost += minValue;
                }
                // 避免相邻刷一种颜色
                else {
                    curCost += minSecondValue;
                }


                if (curCost < curMinValue) {
                    // 最小值变第二小
                    curMinSecondValue = curMinValue;
                    curMinIdx = j;
                    curMinValue = curCost;
                } else if (curCost < curMinSecondValue) {
                    curMinSecondValue = curCost;
                }
            }

            minIdx = curMinIdx;
            minValue = curMinValue;
            minSecondValue = curMinSecondValue;

        }


        return minValue;
    }
}
