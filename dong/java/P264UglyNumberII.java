import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P264UglyNumberII
 * @date 2020/2/2
 */
public class P264UglyNumberII {
    class Solution {
        public int nthUglyNumber(int n) {
            int cnt2 = 0;
            int cnt3 = 0;
            int cnt5 = 0;
            // dp[i]记录第i+1个数，dp[0]=1
            int[] dp = new int[n];
            dp[0] = 1;
            int i = 1;

            while (i < n) {
                dp[i] = Math.min(dp[cnt2] * 2, Math.min(dp[cnt3] * 3, dp[cnt5] * 5));
                if (dp[i] == dp[cnt2] * 2) {
                    cnt2++;
                }
                if (dp[i] == dp[cnt3] * 3) {
                    cnt3++;
                }
                if (dp[i] == dp[cnt5] * 5) {
                    cnt5++;
                }
                i++;
            }

            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new P264UglyNumberII().new Solution().nthUglyNumber(22));
    }
}
