package week178;

import bean.ListNode;
import bean.TreeNode;

/**
 * @author Lam
 * @ClassName P3
 * @date 2020/3/1
 */
public class P3 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return helper(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean helper(ListNode cur, TreeNode root) {
        if (cur == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        boolean result = false;
        if (cur.val == root.val) {
            result = helper(cur.next, root.left) || helper(cur.next, root.right);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
    }
}
