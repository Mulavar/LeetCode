import java.util.HashMap;

/**
 * @author Lam
 * @ClassName P76MinimumWindowSubstring
 * @date 2020/2/11
 */
public class P76MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;
            int count = map.size();
            boolean hasResult = false;
            while (end < s.length()) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)) {
                    int v = map.get(ch);
                    map.put(ch, v - 1);
                    if (v - 1 == 0) {
                        count--;
                    }
                    if (count == 0) {
                        hasResult = true;
                    }
                }

                while (count == 0) {
                    ch = s.charAt(start);
                    if (map.containsKey(ch)) {
                        int v = map.get(ch);
                        map.put(ch, v + 1);
                        if (v == 0) {
                            count++;
                            if (end - start + 1 < maxLen) {
                                maxLen = end - start + 1;
                                maxStart = start;
                                maxEnd = end;
                            }
                        }
                    }
                    start++;
                }

                end++;
            }

            if (!hasResult) {
                return "";
            }

            return s.substring(maxStart, maxEnd + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P76MinimumWindowSubstring().new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new P76MinimumWindowSubstring().new Solution().minWindow("ab", "a"));
    }
}
