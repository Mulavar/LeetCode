import bean.TreeNode;

/**
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 *
 * @author Lam
 * @date 2020/8/30
 */
public class P250CountUnivalueSubtrees {
    int result = 0;

    public int countUnivalSubtrees(TreeNode root) {
        postorder(root);
        return result;
    }

    private boolean postorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean cur = true;
        // 当前节点和子树的节点值不相等 或 子树不满足情况
        boolean left = postorder(root.left);
        if (root.left != null && root.val != root.left.val || !left) {
            cur = false;
        }

        boolean right = postorder(root.right);
        if (root.right != null && root.val != root.right.val || !right) {
            cur = false;
        }

        if (cur) {
            result++;
        }

        return cur;
    }
}
