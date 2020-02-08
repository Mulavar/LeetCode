/**
 * @author Lam
 * @ClassName P222CountCompleteTreeNodes
 * @date 2020/2/8
 */
public class P222CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            TreeNode node = root;
            int leftDepth = depth(root, true);
            int rightDepth = depth(root, false);
            if (leftDepth == rightDepth) {
                return (int) Math.pow(2, leftDepth) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        private int depth(TreeNode node, boolean left) {
            int depth = 0;
            while (node != null) {
                node = left ? node.left : node.right;
                depth++;
            }
            return depth;
        }
    }
}
