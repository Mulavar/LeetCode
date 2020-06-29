package jzoffer;

import bean.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author Lam
 * @date 2020/6/30
 */
public class P26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null||B==null){
            return false;
        }

        if (topEqual(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean topEqual(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return true;
        }

        if (n1 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return topEqual(n1.left, n2.left) && topEqual(n1.right, n2.right);
    }
}
