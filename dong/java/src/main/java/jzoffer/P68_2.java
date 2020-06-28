package jzoffer;

import bean.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author Lam
 * @date 2020/6/29
 */
public class P68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }
        boolean leftP = hasNode(root.left, p);
        boolean leftQ = hasNode(root.left, q);
        boolean rightP = hasNode(root.right, p);
        boolean rightQ = hasNode(root.right, q);

        if ((leftP && rightQ) || (leftQ && rightP)) {
            return root;
        }

        if (leftP && leftQ) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    private boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root == node) {
            return true;
        }

        return hasNode(root.left, node) || hasNode(root.right, node);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
