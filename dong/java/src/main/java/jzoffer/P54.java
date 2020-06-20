package jzoffer;

import bean.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P54 {
    int num = 0;
    int result = 0;

    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || num > k) {
            return;
        }

        inorder(root.right, k);
        num += 1;
        if (num == k) {
            result = root.val;
        }
        inorder(root.left, k);
    }
}
