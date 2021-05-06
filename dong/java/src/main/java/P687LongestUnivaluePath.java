import bean.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class P687LongestUnivaluePath {
    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root==null) {
            return 0;
        }

        preOrder(root);
        return result - 1;
    }

    /**
     * 在比较过程中记录三部分数据：
     * 1. 目前遍历过的最大路径 result
     * 2. 当前节点在路径中 left-root-right，记录不能反返回
     * 3. 当前节点在路径中 [parent]-root-[left, right]，记录并返回给 parent
     */
    private int preOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = preOrder(root.left);
        int right = preOrder(root.right);

        // 包含 left-root-right 的路径
        int countIncludeRoot = 1;

        // 只包含 root-[left、right] 其中一部分
        // 或只有 root
        int countIncludeRootReturnValue = 1;

        // 右子树非空
        if (right != 0 && root.val == root.right.val) {
            countIncludeRoot += right;
            countIncludeRootReturnValue += right;
        }

        // 左子树非空
        if (left != 0 && root.val == root.left.val) {
            countIncludeRoot += left;
            countIncludeRootReturnValue = Math.max(countIncludeRootReturnValue, left + 1);
        }

        result = Math.max(Math.max(countIncludeRoot, Math.max(left, right)), result);
        return countIncludeRootReturnValue;
    }
}
