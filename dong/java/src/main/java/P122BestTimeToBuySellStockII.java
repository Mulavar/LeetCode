/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author Lam
 * @ClassName P122BestTimeToBuySellStockII
 * @date 2020/2/17
 */
public class P122BestTimeToBuySellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int buy = prices[0];

            int result = 0;
            int days = prices.length;

            for (int i = 1; i < days; i++) {
                if (prices[i] > buy) {
                    result += prices[i] - buy;
                }
                buy = prices[i];
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new P122BestTimeToBuySellStockII().new Solution().maxProfit(nums));
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(new P122BestTimeToBuySellStockII().new Solution().maxProfit(nums1));
    }
}
