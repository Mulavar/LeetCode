import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P123BestTimeToBuySellStockIII
 * @date 2020/2/17
 */
public class P123BestTimeToBuySellStockIII {
    class Solution {
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
                    dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);
                    dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
                    dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[len - 1][2][0];
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(new P123BestTimeToBuySellStockIII().new Solution().maxProfit(prices));
    }
}
