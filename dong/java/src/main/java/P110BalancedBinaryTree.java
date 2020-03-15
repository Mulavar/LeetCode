import bean.TreeNode;

/**
 * @author Lam
 * @ClassName P110BalancedBinaryTree
 * @date 2020/2/11
 */
public class P110BalancedBinaryTree {
    class Solution {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            int leftH = height(root.left);
            int rightH = height(root.right);
            return Math.abs(leftH - rightH) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            return root == null ? 0 : 1 + Integer.max(height(root.left), height(root.right));
        }
    }
}
