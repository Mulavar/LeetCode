package jzoffer;

import bean.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P55_2 {
    /**
     * 使用先序遍历的思想，但会导致重复遍历（1. 递归检查子树是否是平衡二叉树；2. 当前节点需要计算高度查看是否平衡）
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }


    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * 使用后序遍历，减少重复度
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return postorder(root) != -1;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lH = postorder(root.left);
        int rH = postorder(root.right);
        if (lH != -1 && rH != -1 && Math.abs(lH - rH) <= 1) {
            return Math.max(lH, rH) + 1;
        }
        return -1;
    }
}
