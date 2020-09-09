import bean.ListNode;

import java.util.*;

/**
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * @author Lam
 * @date 2020/9/9
 */
public class P336PalindromePairs {
    /**
     * 哈希表实现
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        int n = words.length;
        for (int i = 0; i < n; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 将word分为prefix+suffix
            String word = words[i];

            int m = word.length();
            if (m == 0) {
                continue;
            }

            // word[i]放前面
            for (int j = 0; j <= m; j++) {
                String suffix = word.substring(j);
                if (isPalindrome(suffix)) {
                    String prefix = word.substring(0, j);
                    Integer idx = map.getOrDefault(prefix, -1);
                    if (idx != -1 && idx != i) {
                        result.add(Arrays.asList(i, idx));
                    }
                }

            }

            // word[i]放后面
            // note: 这里为什么从1开始，因为当word[i]放后面时，回文判断的是prefix，
            // 这里的prefix和上面的suffix有重复，需要去重
            for (int j = 1; j <= m; j++) {
                String prefix = word.substring(0, j);
                if (isPalindrome(prefix)) {
                    String suffix = word.substring(j);
                    Integer idx = map.getOrDefault(suffix, -1);
                    if (idx != -1 && idx != i) {
                        result.add(Arrays.asList(idx, i));
                    }
                }

            }
        }

        return result;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
