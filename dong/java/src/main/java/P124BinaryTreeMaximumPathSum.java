import bean.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * @author Lam
 * @ClassName P124BinaryTreeMaximumPathSum
 * @date 2020/2/13
 */
public class P124BinaryTreeMaximumPathSum {
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
