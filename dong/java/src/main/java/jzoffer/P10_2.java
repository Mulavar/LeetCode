package jzoffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * @author Lam
 * @date 2020/7/5
 */
public class P10_2 {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) {
            return 1;
        }
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % (int)(1e9 + 7);
        }

        return dp[n];
    }
}
