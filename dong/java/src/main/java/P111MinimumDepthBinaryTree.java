import bean.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author Lam
 * @ClassName P111MinimumDepthBinaryTree
 * @date 2020/2/22
 */
public class P111MinimumDepthBinaryTree {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftH = minDepth(root.left);
            int rightH = minDepth(root.right);
            if (leftH == 0) {
                return rightH + 1;
            } else if (rightH == 0) {
                return leftH + 1;
            } else {
                return Math.min(leftH, rightH) + 1;
            }
        }
    }
}
