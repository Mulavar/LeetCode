/**
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
