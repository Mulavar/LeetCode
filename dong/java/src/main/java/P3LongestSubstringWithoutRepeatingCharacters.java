import java.util.HashMap;

/**
 * @author Lam
 * @ClassName P3LongestSubstringWithoutRepeatingCharacters
 * @date 2020/2/12
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int start = 0;
            int end = 0;
            int result = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            while (end < s.length()) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    result = Math.max(end - start, result);
                    start = map.get(ch) < start ? start : map.get(ch) + 1;
                }
                map.put(ch, end);
                end++;
            }
            return Math.max(result, end - start);
        }
    }
}
