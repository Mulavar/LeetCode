import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 *
 * @author Lam
 * @date 2020/7/22
 */
public class P266PalindromePermutation {
    /**
     * 回文串的字母组成特征，则是最多只能有一个字母出现次数为奇数
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int odd = 0;
        for (Integer count :
                map.values()) {
            if (count % 2 != 0) {
                if (++odd>1) {
                    return false;
                }
            }
        }

        return true;
    }
}
