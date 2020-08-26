import java.util.Arrays;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * @author Lam
 * @date 2020/8/26
 */
public class P318MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        // 预处理
        long[] masks = new long[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int mask = word.charAt(j) - 'a';
                masks[i] |= 1 << mask;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length; j++) {
                // 无重复
                if ((masks[i] & masks[j]) == 0) {
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }

        return result;
    }
}
