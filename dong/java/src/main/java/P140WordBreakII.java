import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * @author Lam
 * @ClassName P140WordBreakII
 * @date 2020/10/1
 */
public class P140WordBreakII {
    private Map<Integer, List<String>> map = new HashMap<>();

    /**
     * dfs+map
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordsSet = new HashSet<>(wordDict);
        wordDict.forEach(word -> {
            wordsSet.add(word);
        });

        map.put(s.length(), new ArrayList<>(Arrays.asList("")));
        return dfs(s, 0, wordsSet);
    }

    /**
     * 计算以i为起始位置的子串的所有切割结果
     */
    private List<String> dfs(String s, int idx, HashSet<String> wordsSet) {
        if (map.containsKey(idx)) {
            return map.get(idx);
        }

        List<String> result = new ArrayList<>();
        for (int i = idx + 1; i <= s.length(); i++) {
            String curSubString = s.substring(idx, i);
            // 找到可切割点
            if (wordsSet.contains(curSubString)) {
                List<String> subResult = dfs(s, i, wordsSet);
                for (String word : subResult) {
                    result.add(curSubString + (word == "" ? "" : " ") + word);
                }
            }
        }

        map.put(idx, result);
        return result;
    }
}
