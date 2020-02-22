import bean.ListNode;
import bean.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author Lam
 * @ClassName P109ConvertSortedListToBinarySearchTree
 * @date 2020/2/22
 */
public class P109ConvertSortedListToBinarySearchTree {
    class Solution {
        /**
         * 暴力平衡二叉树构建
         */
        public TreeNode sortedListToBST(ListNode head) {
            ListNode node = head;
            TreeNode root = null;
            while (node != null) {
                root = insert(root, node.val);
                node = node.next;
            }
            return root;
        }

        //todo 总结二叉平衡树旋转
        private TreeNode insert(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val <= root.val) {
                root.left = insert(root.left, val);
                if (depth(root.left) - depth(root.right) == 2) {
                    TreeNode node = root.left;
                    if (val <= root.left.val) {
                        // LL
                        root.left = node.right;
                        node.right = root;
                        root = node;
                    } else {
                        // LR
                        TreeNode tmp = node.right;
                        node.right = tmp.left;
                        root.left = tmp.right;
                        tmp.left = node;
                        tmp.right = root;
                        root = tmp;
                    }
                }
            } else {
                root.right = insert(root.right, val);
                if (depth(root.right) - depth(root.left) == 2) {
                    TreeNode node = root.right;
                    if (val > root.right.val) {
                        // RR
                        root.right = node.left;
                        node.left = root;
                        root = node;
                    } else {
                        // RL
                        TreeNode tmp = node.left;
                        root.right = tmp.left;
                        node.left = tmp.right;
                        tmp.right = node;
                        tmp.left = root;
                        root = tmp;
                    }
                }
            }
            return root;
        }

        // 用于计算高度以看是否需要调整
        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

    class Solution1 {
        /**
         * 利用快慢指针折半构建平衡二叉树
         */
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            } else if (head.next == null) {
                return new TreeNode(head.val);
            }

            ListNode leftTail = head;
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null) {
                leftTail = leftTail.next;
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.val);
            leftTail.next = null;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            return root;
        }
    }
}
