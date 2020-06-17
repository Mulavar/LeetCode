package jzoffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * @author Lam
 * @ClassName P33
 * @date 2020/6/16
 */
public class P33 {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        int[] inorder = new int[n];
        System.arraycopy(postorder, 0, inorder, 0, n);
        Arrays.sort(inorder);

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private boolean build(int[] inorder, int leftIn, int rightIn, int[] postorder, int leftPost, int rightPost) {
        if (rightIn < leftIn) {
            return true;
        }

        int root = postorder[rightPost];
        int midIdx = map.get(root);
        if (midIdx > rightIn || midIdx < leftIn) {
            return false;
        }

        int leftLen = midIdx - leftIn;
        return build(inorder, leftIn, midIdx - 1, postorder, leftPost, leftPost + leftLen - 1)
                && build(inorder, midIdx + 1, rightIn, postorder, leftPost + leftLen, rightPost - 1);
    }

    /**
     * 采用单调栈思想，但仍需对数组排序
     */
    public boolean verifyPostorder1(int[] postorder) {
        int n = postorder.length;
        int[] inorder = new int[n];
        System.arraycopy(postorder, 0, inorder, 0, n);
        Arrays.sort(inorder);

        int i = n - 1;
        int j = n - 1;
        Stack<Integer> stack = new Stack<>();
        while (j >= 0) {
            int cur = postorder[j--];
            while (!stack.isEmpty() && stack.peek() > cur) {
                if (stack.pop() != inorder[i--]) {
                    return false;
                }
            }
            stack.push(cur);
        }
        return true;
    }

    public boolean verifyPostorder2(int[] postorder) {
        int n = postorder.length;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        int i = n - 1;
        while (i >= 0) {
            if (postorder[i] > root) {
                return false;
            }
            //如果是左子树的节点
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                //找出当前节点的root，当前节点在root的左子树中
                root = stack.pop();
            }
            stack.push(postorder[i--]);
        }
        return true;
    }
}
