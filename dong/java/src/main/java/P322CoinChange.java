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

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new P322CoinChange().coinChange(coins, 11));

    }
}
