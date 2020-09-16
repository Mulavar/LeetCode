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
        // dp[i][j][0] 表示第i天最多第j笔交易且无股票的利润
        // dp[i][j][1] 表示第i天最多第j笔交易手中有股票的利润
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
}
