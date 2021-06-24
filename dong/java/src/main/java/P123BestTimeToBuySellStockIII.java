import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Lam
 * @ClassName P123BestTimeToBuySellStockIII
 * @date 2020/2/17
 */
public class P123BestTimeToBuySellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        // dp[i][j][0] 表示第i天最多j笔交易且无股票的利润
        // dp[i][j][1] 表示第i天最多j笔交易手中有股票的利润
        int[][][] dp = new int[len][3][2];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i][1][0] = 0;
                dp[i][1][1] = -prices[i];
                dp[i][2][0] = 0;
                dp[i][2][1] = -prices[i];
            } else {
                dp[i][1][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][1][0]);
                dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
                dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int len = prices.length;
        // maxProfit 中的三维 dp ，由于第 i 天严格依赖第 i-1 天，因此可以删去天数那一维度
        // 简化为二维
        // dp[j][0] 表示当天最多第j笔交易且无股票的利润
        // dp[j][1] 表示当天最多第j笔交易手中有股票的利润
        int[][] dp = new int[3][2];
        // init dp
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        dp[2][0] = 0;
        dp[2][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
            dp[1][1] = Math.max(dp[1][1], -prices[i]);
            dp[2][0] = Math.max(dp[2][0], dp[2][1] + prices[i]);
            dp[2][1] = Math.max(dp[2][1], dp[1][0] - prices[i]);
        }
        return dp[2][0];
    }

    public int maxProfit2(int[] prices) {
        //
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        // profits[i] 表示到i天时第一次交易股票能得到的最大利润
        int[] profits = new int[length];
        int curMin = prices[0];
        for (int i = 1; i < length; i++) {
            profits[i] = Math.max(profits[i - 1], prices[i] - curMin);
            if (prices[i] < curMin) {
                curMin = prices[i];
            }
        }

        int idx = length - 1;
        int result = profits[idx];
        int curMax = 0;
        // 倒序将区间分为两部分
        // [0, idx - 1]: 第一次交易
        // [idx, ]: 第二次交易
        // 我们需要对每个 idx 求第二次交易的最大值，然后加上 profits[idx - 1]
        while (idx > 1) {
            if (prices[idx] > curMax) {
                curMax = prices[idx];
            } else if (curMax - prices[idx] + profits[idx - 1] > result) {
                result = curMax - prices[idx] + profits[idx - 1];
            }
            idx--;
        }

        return result;
    }
}
