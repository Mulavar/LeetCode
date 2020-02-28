/**
 * 编写一段程序来查找第 n 个超级丑数。
 * <p>
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * @author Lam
 * @ClassName P313SuperUglyNumber
 * @date 2020/2/28
 */
public class P313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int[] k = new int[primes.length];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int minV = Integer.MAX_VALUE;
            for (int j = 0; j < k.length; j++) {
                minV = Math.min(dp[k[j]] * primes[j], minV);
            }

            for (int j = 0; j < k.length; j++) {
                if (dp[k[j]] * primes[j] == minV) {
                    k[j]++;
                }
            }
            dp[i] = minV;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        new P313SuperUglyNumber().nthSuperUglyNumber(12, primes);
    }
}
