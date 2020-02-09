import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P99RecoverBinarySearchTree
 * @date 2020/2/8
 */
public class P99RecoverBinarySearchTree {
    /**
     * 两个节点交换，中序遍历一定会有1或2处逆序的地方
     */
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }

        }

        public void recoverTree(TreeNode root) {
            // nodes 表示被交换的两个节点
            TreeNode[] nodes = new TreeNode[2];
            inOrder(null, root, new boolean[1], nodes);
            System.out.println(Arrays.toString(nodes));
            int val = nodes[0].val;
            nodes[0].val = nodes[1].val;
            nodes[1].val = val;
        }

        private TreeNode inOrder(TreeNode pre, TreeNode cur, boolean[] first, TreeNode[] res) {
            if (cur == null) {
                return null;
            }

            TreeNode pre1 = inOrder(pre, cur.left, first, res);
            if (pre1 != null) {
                pre = pre1;
            }
            if (pre != null) {
                if (pre.val > cur.val) {
                    if (first[0]) {
                        res[1] = cur;
                    } else {
                        res[0] = pre;
                        res[1] = cur;
                        first[0] = true;
                    }
                }
            }
            TreeNode cur1 = inOrder(cur, cur.right, first, res);
            return cur1 == null ? cur : cur1;
        }
    }

    public static void main(String[] args) {
        Solution.TreeNode root = new P99RecoverBinarySearchTree().new Solution().new TreeNode(3);
        root.left = new P99RecoverBinarySearchTree().new Solution().new TreeNode(1);
        root.right = new P99RecoverBinarySearchTree().new Solution().new TreeNode(4);
        root.right.left = new P99RecoverBinarySearchTree().new Solution().new TreeNode(2);
        P99RecoverBinarySearchTree.Solution.TreeNode realRoot = root.right.left;
        new P99RecoverBinarySearchTree().new Solution().recoverTree(root);
//        System.out.println("root" + root);

        Solution.TreeNode root1 = new P99RecoverBinarySearchTree().new Solution().new TreeNode(2);
        root1.left = new P99RecoverBinarySearchTree().new Solution().new TreeNode(1);
        root1.left.right = new P99RecoverBinarySearchTree().new Solution().new TreeNode(3);
        new P99RecoverBinarySearchTree().new Solution().recoverTree(root1);
//        System.out.println("***" + root1);
    }
}
