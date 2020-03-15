/**
 * @author Lam
 * @ClassName P357CountNumbersUniqueDigits
 * @date 2020/2/6
 */
public class P357CountNumbersUniqueDigits {
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {

            if (n > 10) {
                n = 10;
            }
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 10;

            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] - dp[i - 2]) * (11 - i) + dp[i - 1];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new P357CountNumbersUniqueDigits().new Solution().countNumbersWithUniqueDigits(3));
    }
}
