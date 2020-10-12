/**
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * @author Lam
 * @ClassName P313SuperUglyNumber
 * @date 2020/2/28
 */
public class P313SuperUglyNumber {
    /**
     * 多重下标记录数组
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        // dp[i] 表示第 i+1 个超级丑数
        int[] dp = new int[n];
        // k[i] 表示乘上 primes[i] 得到的新超级丑数在dp数组中的下标
        int[] k = new int[len];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int minV = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                minV = Math.min(dp[k[j]] * primes[j], minV);
            }

            for (int j = 0; j < len; j++) {
                if (dp[k[j]] * primes[j] == minV) {
                    k[j]++;
                }
            }
            dp[i] = minV;
        }

        return dp[n - 1];
    }
}
