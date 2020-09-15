import java.util.Arrays;
import java.util.HashSet;

/**
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 *
 * @author Lam
 * @ClassName P1044LongestDuplicateSubstring
 * @date 2020/9/15
 */
public class P1044LongestDuplicateSubstring {
    /**
     * 使用 Rabin-Karp 算法搜索重复子串，通过O(1)的hash计算+set去重，
     * 如果存在重复子串，返回start，否则返回-1
     */
    public int search(int length, int a, long modulus, int n, int[] nums) {
        // 计算初试子串的hash—S[:length]
        long hash = 0;
        for (int i = 0; i < length; ++i) {
            hash = (hash * a + nums[i]) % modulus;
        }

        // set去重
        HashSet<Long> seen = new HashSet();
        seen.add(hash);

        // 子串起始字母的hash值
        long aL = 1;
        for (int i = 1; i <= length; ++i) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - length + 1; ++start) {
            // 计算新子串的hash
            hash = (hash * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            hash = (hash + nums[start + length - 1]) % modulus;
            if (seen.contains(hash)) {
                return start;
            }
            seen.add(hash);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // 方便计算hash值
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int) S.charAt(i) - (int) 'a';
        }
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        int left = 1, right = n;
        // 最长重复子串长度
        int length;

        // 二分法找出长度
        while (left != right) {
            length = left + (right - left) / 2;
            if (search(length, a, modulus, n, nums) != -1) {
                left = length + 1;
            } else {
                right = length;
            }
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    /**
     * *******************************
     * 使用KMP算法，结果会TLE
     * *******************************
     */
    @Deprecated
    public String longestDupSubstring1(String s) {
        int len = s.length();
        // 目前得到的最大重复子串长度
        int maxLen = -1;
        // 目前得到的最大重复子串起始位置
        int st = -1;

        int minLen = 0;

        // next数组，实现KMP算法
        int[] next = new int[len + 1];

        for (int i = 0; i < len - minLen; i++) {
            Arrays.fill(next, 0);
            for (int j = i; j < len + 1; j++) {
                if (j == i) {
                    next[j] = -1;
                } else if (j == i + 1) {
                    next[j] = i;
                } else {
                    int tmp = next[j - 1];

                    // 通过next数组找最长重复前后缀
                    while (tmp >= i && s.charAt(j - 1) != s.charAt(tmp)) {
                        tmp = next[tmp];
                    }

                    if (tmp < i) {
                        next[j] = i;
                    } else {
                        // 更新最大重复子串
                        next[j] = tmp + 1;
                        if (tmp + 1 - i > maxLen) {
                            maxLen = tmp + 1 - i;
                            st = i;
                            minLen = maxLen;
                        }
                    }
                }
            }
        }

        if (st == -1) {
            return "";
        }

        return s.substring(st, st + maxLen);
    }
}
