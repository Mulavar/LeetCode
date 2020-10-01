/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * @author Lam
 * @ClassName P115DistinctSubsequences
 * @date 2020/9/30
 */
public class P115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();

        if (m == 0 || n == 0) {
            return 0;
        }

        // dp[i][j]表示t[:i]在s[:j]中出现的次数
        int[][] dp = new int[m][n];
        char t0 = t.charAt(0);
        // 初始化
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t0) {
                dp[0][i] = i == 0 ? 1 : dp[0][i - 1] + 1;
            } else {
                dp[0][i] = i == 0 ? 0 : dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    // t[:i-1]在s[:j-1]中出现次数 + t[:i]在s[:j-1]中出现次数
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // 相当于t[:i]在s[:j-1]中出现次数
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
