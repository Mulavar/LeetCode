/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * @author Lam
 * @date 2020/5/22
 */
public class P1143LongestCommonSubsequence {
    /**
     * 动态规划求解最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = text2.charAt(0) == text1.charAt(i) ? 1 : i > 0 ? dp[i - 1][0] : 0;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = text1.charAt(0) == text2.charAt(i) ? 1 : i > 0 ? dp[0][i - 1] : 0;
        }

        // dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 在上述解法的基础上优化了空间复杂度
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        // 引入tmp，为了防止依赖值被覆盖
        int tmp;
        int last = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = text1.charAt(0) == text2.charAt(i) ? 1 : i > 0 ? dp[i - 1] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp = dp[j];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = j == 0 ? 1 : last + 1;
                } else {
                    dp[j] = j == 0 ? dp[j] : Math.max(dp[j], dp[j - 1]);
                }
                last = tmp;
            }
        }

        return dp[n - 1];
    }
}
