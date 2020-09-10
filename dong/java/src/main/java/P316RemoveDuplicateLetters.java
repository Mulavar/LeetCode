import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * @author Lam
 * @ClassName P316RemoveDuplicateLetters
 * @date 2020/8/17
 */
public class P316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        // 去重，存储栈里已有的字符
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!set.contains(cur)) {
                while (!stack.isEmpty() && stack.peekLast() > cur && s.lastIndexOf(stack.peekLast()) > i) {
                    set.remove(stack.removeLast());
                }

                stack.addLast(cur);
                set.add(cur);
            }
        }

        StringBuilder builder = new StringBuilder();
        stack.forEach(builder::append);
        return builder.toString();
    }
}
