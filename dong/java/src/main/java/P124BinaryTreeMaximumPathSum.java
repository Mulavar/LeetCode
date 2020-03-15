import bean.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * @author Lam
 * @ClassName P124BinaryTreeMaximumPathSum
 * @date 2020/2/13
 */
public class P124BinaryTreeMaximumPathSum {
    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] result = new int[]{Integer.MIN_VALUE};
            postOrder(root, result);
            return result[0];
        }

        private int postOrder(TreeNode root, int[] result) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(postOrder(root.left, result), 0);
            int right = Math.max(postOrder(root.right, result), 0);
            result[0] = Math.max(result[0], left + right + root.val);
            return root.val + Math.max(left, right);
        }
    }
}
