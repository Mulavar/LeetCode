/**
 * @author Lam
 * @ClassName P309BestTimeToBuyAndSellStockWithCooldown
 * @date 2020/2/28
 */
public class P309BestTimeToBuyAndSellStockWithCooldown {
    /**
     * 通用dp解法
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days < 2) {
            return 0;
        }
        // 有两类状态
        // 第一类是第几天
        // 第二类是有股票和无股票两个状态，0表示无股票，1表示有股票
        int[][] dp = new int[days][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return Math.max(dp[days - 1][0], dp[days - 1][1]);
    }

    /**
     * 使用有限状态机的解法
     *
     * @param prices 股票每天价格
     * @return 最大利润
     */
    public int maxProfit1(int[] prices) {
        // 一共有三个状态
        // empty 空仓
        // full 持仓
        // cool 冷冻期
        // 引起状态变化的操作也是三种：买入，卖出，无操作
        // 对于买入引起的状态变化有：empty (买入)=> full
        // 对于卖出引起的状态变化有：full (卖出)=> empty
        // 对于无操作引起的状态变化有：
        //      1. empty (无操作)=> empty
        //      2. full (无操作)=> full
        //      3. cool (无操作)=> empty

        int full = Integer.MIN_VALUE;
        int empty = 0;
        int cool = 0;

        for (int i = 0; i < prices.length; i++) {
            int preFull = full;
            full = Math.max(empty - prices[i], full);
            empty = Math.max(empty, cool);
            cool = preFull + prices[i];
        }

        return Math.max(empty, cool);
    }
}
