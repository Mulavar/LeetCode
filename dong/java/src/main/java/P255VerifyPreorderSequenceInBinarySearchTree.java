import java.util.LinkedList;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 * 你可以假定该序列中的数都是不相同的。
 *
 * @author Lam
 * @date 2020/8/29
 */
public class P255VerifyPreorderSequenceInBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        LinkedList<Integer> stack = new LinkedList<>();

        int root = Integer.MIN_VALUE;

        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                root = stack.pop();
            }

            stack.push(preorder[i]);

        }

        return true;
    }
}
