import java.util.Arrays;
import java.util.Stack;

/**
 * @author Lam
 * @ClassName P32LongestValidParentheses
 * @date 2020/2/5
 */
public class P32LongestValidParentheses {
    // the most quick solution
    class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() <= 1) {
                return 0;
            }
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
                        dp[i] = 2;
                    } else if (dp[i - 1] < 0) {
                        dp[i] = -1;
                    } else {
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
    }

    class Solution1 {
        public int longestValidParentheses(String s) {
            boolean[] check = new boolean[s.length()];
            Stack<Node> stack = new Stack<>();

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);

                if(c == ')') {
                    if(!stack.isEmpty()) {
                        Node curr = stack.pop();
                        check[curr.index] = true;
                        check[i] = true;
                    }
                } else {
                    stack.push(new Node(i, '('));
                }
            }
            int longest = Integer.MIN_VALUE;
            int count = 0;
            for(int i = 0; i < check.length; ++i) {
                if(check[i]) {
                    ++count;
                }
                if(!check[i]) {
                    longest = Math.max(longest, count);
                    count = 0;
                }
            }
            longest = Math.max(longest, count);
            return longest;
        }

        private class Node {
            public int index;
            public char character;

            public Node(int index, char character) {
                this.index = index;
                this.character = character;
            }
        }
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = "(()";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = ")()";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = ")()())";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = ")(";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = "())";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
        s = "(()())";
        System.out.println(new P32LongestValidParentheses().new Solution().longestValidParentheses(s));
    }
}
