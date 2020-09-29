import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * @author Lam
 * @ClassName P32LongestValidParentheses
 * @date 2020/2/5
 */
public class P32LongestValidParentheses {
    // the most quick solution
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        //dp表示配对长度，小于0表示配对失败
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '(') {
            dp[0] = 0;
        } else {
            dp[0] = -1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (dp[i - 1] == 0) {
                    // () 情况
                    dp[i] = 2;
                } else if (dp[i - 1] < 0) {
                    // 无法配对的情况
                    dp[i] = -1;
                } else {
                    // (()) 嵌套括号的情况
                    int last = i - 1;
                    while (last >= 0 && dp[last] > 0) {
                        last = last - dp[last];
                    }

                    dp[i] = last >= 0 && dp[last] == 0 ? i - last + 1 : -1;
                }
            }
        }

        int maxLen = 0;
        int curLen = 0;
        int idx = s.length() - 1;
        int end = idx;
        while (end > 0) {
            if (dp[end] <= 0) {
                maxLen = Math.max(maxLen, curLen);
                curLen = 0;
                end--;
            } else {
                curLen += dp[end];
                end -= dp[end];
            }
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    /**
     * 使用一个辅助标记数组
     */
    public int longestValidParentheses1(String s) {
        boolean[] check = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!stack.isEmpty()) {
                    check[stack.pop()] = true;
                    check[i] = true;
                }
            } else {
                stack.push(i);
            }
        }

        // 最长有效括号的问题现在转换为check数组最长的true序列
        int longest = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < check.length; ++i) {
            if (check[i]) {
                ++count;
            }
            if (!check[i]) {
                longest = Math.max(longest, count);
                count = 0;
            }
        }
        longest = Math.max(longest, count);
        return longest;
    }

    /**
     * 取消辅助标记数组，利用栈的特性
     */
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    /**
     * 1. 最长有效括号串，不管从左往右还是从右往左其左右括号数一样，利用这个特性
     * 2. 从左往右如果出现右括号数大于左括号时，则需要重新寻找最长有效括号，逆序遍历同
     */
    public int longestValidParentheses3(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * right);
            } else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * right);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return result;
    }
}
