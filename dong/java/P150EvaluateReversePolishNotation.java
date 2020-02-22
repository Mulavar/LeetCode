import java.util.Stack;

/**
 * @author Lam
 * @ClassName P150EvaluateReversePolishNotation
 * @date 2020/2/22
 */
public class P150EvaluateReversePolishNotation {
    class Solution {
        /**
         * 优化点：
         * 使用数组，最大长度为tokens.length / 2 + 1
         * Integer.parseInt代替Integer.valueOf,减少自动拆箱装箱操作
         */
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            int i = 0;
            while (i < tokens.length) {
                switch (tokens[i]) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int a1 = stack.pop();
                        int a2 = stack.pop();
                        stack.push(a2 / a1);
                        break;
                    default:
                        // parseInt比valueOf快
                        stack.push(Integer.parseInt(tokens[i]));
                        break;
                }
                i++;
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String s = new String("1");
        switch (s) {
            case "1":
                System.out.println("匹配");
        }
    }
}
