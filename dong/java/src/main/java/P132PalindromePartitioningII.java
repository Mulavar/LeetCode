import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 *
 * @author Lam
 * @ClassName P132PalindromePartitioningII
 * @date 2020/10/1
 */
public class P132PalindromePartitioningII {
    private Map<Integer, Integer> map = new HashMap<>();

    public int minCut(String s) {
        return dfs(s, 0);
    }

    /**
     * 切割string[start:]部分最少需要次数
     */
    private int dfs(String string, int start) {
        // 记录尝试切割过的最优状态，减少遍历次数
        if (map.containsKey(start)) {
            return map.get(start);
        }

        // 到string末尾 或 剩余部分都是回文串
        if (start == string.length() || isPalindrome(string, start, string.length() - 1)) {
            return 0;
        }


        int result = Integer.MAX_VALUE;
        for (int i = start; i < string.length(); i++) {
            if (isPalindrome(string, start, i)) {
                // 尝试切割
                result = Math.min(result, 1 + dfs(string, i + 1));
            }
        }

        map.put(start, result);
        return result;
    }

    private boolean isPalindrome(String string, int start, int end) {
        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
