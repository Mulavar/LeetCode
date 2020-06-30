package jzoffer;

import bean.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author Lam
 * @date 2020/7/1
 */
public class P28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        reverse(root.left);
        return equal(root.left, root.right);
    }

    private boolean equal(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val!=r2.val) {
            return false;
        }

        return equal(r1.left, r2.left)&&equal(r1.right, r2.right);
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverse(root.left);
        reverse(root.right);
    }
}
