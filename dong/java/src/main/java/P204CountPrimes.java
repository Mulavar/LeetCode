import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @author Lam
 * @date 2020/6/3
 */
public class P204CountPrimes {
    public int countPrimes(int n) {
        // 0 1 不算质数
        if (n < 2) {
            return 0;
        }
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i < n; i++) {
            int idx = i;
            int k = 2;
            while (primes[idx] && idx * k < n) {
                primes[idx * k] = false;
                k++;
            }

        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                result++;
            }
        }

        return result;
    }
}
