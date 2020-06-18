package jzoffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @author Lam
 * @ClassName P31
 * @date 2020/6/16
 */
public class P31 {
    /**
     * 模拟解法，模拟push和pop操作确认序列是否符合要求
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            //两个push可以合成一步，看下面的优化写法
            while (i < n && pushed[i] != popped[j]) {
                stack.push(pushed[i++]);
            }
            if (i < n) {
                stack.push(pushed[i++]);
            }
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        if (j < n) {
            return false;
        }
        return true;
    }

    /**
     * 代码优化版
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < n) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
