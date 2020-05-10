import java.util.Arrays;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @author Lam
 * @date 2020/5/10
 */
public class P72EditDistance {
    //自顶向下的记忆化搜索
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }

        int[][] memory = new int[word1.length()][word2.length()];

        return costOfChange(word1, 0, word2, 0, memory);
    }

    private int costOfChange(String source, int sIdx, String target, int tIdx, int[][] memory) {
        if (source.length() == sIdx) {
            return target.length() - tIdx;
        } else if (target.length() == tIdx) {
            return source.length() - sIdx;
        }

        if (memory[sIdx][tIdx] != 0) {
            return memory[sIdx][tIdx];
        }

        int result;
        if (source.charAt(sIdx) == target.charAt(tIdx)) {
            result = costOfChange(source, sIdx + 1, target, tIdx + 1, memory);
        } else {
            //替换一个字符
            //删除一个字符
            //增加一个字符
            result = Math.min(Math.min(costOfChange(source, sIdx + 1, target, tIdx + 1, memory), costOfChange(source, sIdx + 1, target, tIdx, memory)),
                    costOfChange(source, sIdx, target, tIdx + 1, memory)) + 1;
        }
        memory[sIdx][tIdx] = result;
        return result;
    }

    //自底向上的动态规划
    public int minDistance1(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        } else if (word2.isEmpty()) {
            return word1.length();
        }
        if (word1.length() < word2.length()) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
        }

        int[][] dp = new int[word1.length()][word2.length()];
        boolean flag1 = false;
        boolean flag2 = false;
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 0; i < word2.length(); i++) {
            if (flag1 || word1.charAt(0) == word2.charAt(i)) {
                dp[0][i] = i;
                if (!flag1) {
                    flag1 = true;
                }
            } else {
                dp[0][i] = i + 1;
            }
        }

        for (int i = 0; i < word1.length(); i++) {
            if (flag2 || word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = i;
                if (!flag2) {
                    flag2 = true;
                }
            } else {
                dp[i][0] = i + 1;
            }
        }

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[word1.length()-1][word2.length()-1];
    }
}
