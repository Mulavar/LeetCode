/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * @author Lam
 * @ClassName P343IntegerBreak
 * @date 2020/2/6
 */
public class P343IntegerBreak {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new P343IntegerBreak().new Solution().integerBreak(12));
    }
}
