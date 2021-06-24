/**
 * prices[i] 表示每日股票的价格
 * 只准交易一次，最大收益为多少
 */
public class P121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            } else if (prices[i] - curMin > maxProfit) {
                maxProfit = prices[i] - curMin;
            }
        }

        return maxProfit;
    }
}
