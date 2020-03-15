import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P279PerfectSquares
 * @date 2020/2/6
 */
public class P279PerfectSquares {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int i = 1; i <= n; i++) {
                int j = 1;

                while (j * j < i) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    j++;
                }

                if (j * j == i) {
                    dp[i] = 1;
                }
            }

            return dp[n];
        }
    }

    class Solution1 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; i + j * j <= n; j++) {
                    dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
                }
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new P279PerfectSquares().new Solution().numSquares(i));
        }

    }
}
