/**
 * @author Lam
 * @ClassName P14LongestCommonPrefix
 * @date 2020/1/20
 */
public class P14LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            boolean common = true;
            int len = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length; i++) {
                len = Math.min(strs[i].length(), len);
            }

            if (len == Integer.MAX_VALUE) {
                return "";
            }
            int k = 0;
            while (k < len && common) {
                char ch = strs[0].charAt(k);
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].charAt(k) != ch) {
                        common = false;
                        break;
                    }
                }
                if (common) {
                    k++;
                }
            }

            return strs[0].substring(0, k);
        }
    }
}
