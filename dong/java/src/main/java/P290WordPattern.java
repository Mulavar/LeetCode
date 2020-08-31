import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * @author Lam
 * @date 2020/8/30
 */
public class P290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<String, String> pattern2Word = new HashMap<>();
        Map<String, String> word2Pattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String p = pattern.substring(i, i + 1);
            if (pattern2Word.containsKey(p)) {
                if (!pattern2Word.get(p).equals(words[i])) {
                    return false;
                }
            } else {
                if (word2Pattern.containsKey(words[i])) {
                    return false;
                }

                pattern2Word.put(p, words[i]);
                word2Pattern.put(words[i], p);
            }

        }

        return true;
    }
}
