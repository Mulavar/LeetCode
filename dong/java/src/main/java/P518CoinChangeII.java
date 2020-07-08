import java.util.Arrays;

/**
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * @author Lam
 * @date 2020/7/8
 */
public class P518CoinChangeII {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        int n = coins.length;
        if (amount == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        /* 先写二维解法，再优化
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i > 0) {
                    if (j >= coins[i]) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (j >= coins[i]) {
                    dp[i][j] = dp[i][j - coins[i]];
                }

            }
        }

        return dp[n - 1][amount];*/

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
