import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * @author Lam
 * @date 2020/7/18
 */
public class P301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        // todo 可以使用List，在递归过程中碰到连续一样的字符，做去重处理
        Set<String> result = new HashSet<>();

        // 需要删除的左右括号数
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right = left == 0 ? right + 1 : right;
                left = left == 0 ? left : left - 1;
            }
        }

        dfs(result, s, 0, left, right);
        return new ArrayList<>(result);
    }

    private void dfs(Set<String> result, String s, int idx, int left, int right) {
        // 边界条件判断
        if (left < 0 || right < 0) {
            return;
        }

        if (idx == s.length()) {
            // todo 可优化：在递归过程中记录当前左右括号个数即可判断是否是合法括号串
            if (left == 0 && right == 0 && isValid(s)) {
                result.add(s);
            }
            return;
        }


        char ch = s.charAt(idx);
        if (ch != '(' && ch != ')') {
            dfs(result, s, idx + 1, left, right);
        } else if (ch == '(') {
            // 删除左括号
            dfs(result, s.substring(0, idx) + s.substring(idx + 1), idx, left - 1, right);

            // 不删除左括号
            dfs(result, s, idx + 1, left, right);
        } else {
            // 删除右括号
            dfs(result, s.substring(0, idx) + s.substring(idx + 1), idx, left, right - 1);

            // 不删除右括号
            dfs(result, s, idx + 1, left, right);
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                left--;
                if (left < 0) {
                    return false;
                }
            }
        }
        return left == 0;
    }


}
