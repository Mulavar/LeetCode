import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Lam
 * @ClassName P22GenerateParentheses
 * @date 2020/1/21
 */
public class P22GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<String>();
            if (n == 0) {
                return result;
            }
            generate(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        // k 可以配对的左括号， leftCnt 已放入的左括号
        public void generate(List<String> result, StringBuilder parenthesis, int leftCnt, int k, int n) {
            if (parenthesis.length() == 2 * n) {
                result.add(parenthesis.toString());
                return;
            }

            if (leftCnt == n) {
                parenthesis.append(")");
                generate(result, parenthesis, leftCnt, k - 1, n);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            } else if (leftCnt == 0) {
                parenthesis.append("(");
                generate(result, parenthesis, leftCnt + 1, k + 1, n);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            } else {
                parenthesis.append("(");
                generate(result, parenthesis, leftCnt + 1, k + 1, n);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
                if (k > 0) {
                    parenthesis.append(")");
                    k--;
                    generate(result, parenthesis, leftCnt, k, n);
                    parenthesis.deleteCharAt(parenthesis.length() - 1);
                }
            }
        }
    }

    class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<String>();
            HashSet<String> parenthesis = new HashSet<>();
            parenthesis.add("()");
            if (n == 0) {
                return result;
            } else if (n == 1) {
                return new ArrayList<String>(parenthesis);
            }

            while (n > 1) {
                HashSet<String> newParenthesis = new HashSet<>();
                for (String p : parenthesis) {
                    for (int i = 0; i <= p.length(); i++) {
                        newParenthesis.add(p.substring(0, i) + "()" + p.substring(i));
                    }
//                    new StringBuilder(p);
                }
                parenthesis = newParenthesis;
                n--;
            }
            return new ArrayList<String>(parenthesis);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (!new HashSet<>(new P22GenerateParentheses().new Solution().generateParenthesis(i))
                    .equals(new HashSet<>(new P22GenerateParentheses().new Solution1().generateParenthesis(i)))) {
                System.out.println(i + " not equal");
            }
        }

    }
}
