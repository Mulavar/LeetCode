package jzoffer;

import bean.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author Lam
 * @date 2020/7/1
 */
public class P27 {
    public TreeNode mirrorTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root==null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverse(root.left);
        reverse(root.right);
    }
}
