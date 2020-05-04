/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Lam
 * @ClassName P188BestTimeToBuyAndSellStockIV
 * @date 2020/5/4
 */
public class P188BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 相当于允许无限次交易，题目简化为p122，退化为0n
        if (k >= (n + 1) / 2) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                result += (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0);
            }
            return result;
        }
        return dpSolve(prices, k, n);

    }

    private int dpSolve(int[] prices, int k, int n) {
        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
}
