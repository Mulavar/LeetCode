package jzoffer;

import bean.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *
 * @author Lam
 * @date 2020/6/29
 */
public class P68_1 {
    /**
     * 递归解法，每次判断后能去除掉一边子树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if (root == p || root == q) {
            return root;
        }

        if ((root.val < pVal && root.val > qVal) || (root.val < qVal && root.val > pVal)) {
            return root;
        }

        if (root.val < pVal && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return lowestCommonAncestor(root.left, p, q);
    }

    /**
     * 循环解法
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        while (root != null) {
            if (root.val < pVal && root.val < qVal) {
                root = root.right;
            } else if (root.val > pVal && root.val > qVal) {
                root = root.left;
            } else {
                return root;
            }
        }

        return root;
    }
}
