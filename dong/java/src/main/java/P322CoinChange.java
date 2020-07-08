import java.util.*;

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
        //dp[i]表示组成i最少需要多少个硬币
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

    private int solve(int[] coins, int idx, int amount) {
        if (amount == 0) {
            return 0;
        }

        //使用暴力递归法，会有很多重复的无效状态
        return Math.min(solve(coins, idx, amount - coins[idx]) + 1, solve(coins, idx + 1, amount));
    }

    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        //i j 前i种硬币，价值为j最少需要多少个
        //dp[i][j] = min(dp[i][j-coins[i], dp[i-1][j]) + 1;
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[j] = amount + 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new P322CoinChange().coinChange(coins, 11));

    }
}
