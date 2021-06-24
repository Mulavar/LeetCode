import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @author Lam
 * @ClassName P322CoinChange
 * @date 2020/3/29
 */
public class P322CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示组成i最少需要多少个硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        // dp[i][j] 表示前 i 种硬币组成 j 最少需要的硬币个数
        // dp[i][j] = min(dp[i][j-coins[i]] + 1, dp[i][j])
        // 由于 dp[i] 依赖于 dp[i] 的上一个状态，单向无覆盖
        // 所以可以直接优化为一维 dp[j], 表示组成 j 最少需要多少个硬币
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[j] = amount + 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}