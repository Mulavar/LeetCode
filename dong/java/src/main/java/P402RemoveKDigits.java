import java.util.LinkedList;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * @author Lam
 * @ClassName P402RemoveKDigits
 * @date 2020/8/17
 */
public class P402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        // 存保留的数字
        LinkedList<Character> stack = new LinkedList<>();
        int remained = num.length() - k;

        for (int i = 0; i < num.length(); i++) {
            // 最多删除k次
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > num.charAt(i)) {
                stack.removeLast();
                k--;
            }

            // 每个都会加入到栈中
            stack.addLast(num.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < remained; i++) {
            builder.append(stack.removeFirst());
        }

        // 去前导0保留单个0的情况
        String result = builder.toString();
        while (result.length() > 1 && result.startsWith("0")) {
            result = result.substring(1);
        }

        return result;
    }
}
