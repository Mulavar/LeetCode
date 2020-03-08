package dweek21;

import bean.TreeNode;

/**
 * @author Lam
 * @ClassName P3
 * @date 2020/3/7
 */
public class P3 {
    public int longestZigZag(TreeNode root) {
        int[] ls = zSearch(root);
        return Math.max(ls[0], Math.max(ls[1], Math.max(ls[2], ls[3]))) - 1;
    }

    // 0 root and left 1 root and right 2 root.left 3 root.right
    private int[] zSearch(TreeNode root) {
        if (root == null) {
            return new int[4];
        }
        int[] leftArr = zSearch(root.left);
        int[] rightArr = zSearch(root.right);
        int[] result = new int[4];

        result[0] = leftArr[1] + 1;
        result[1] = rightArr[0] + 1;
        result[2] = Math.max(leftArr[0], Math.max(leftArr[1], Math.max(leftArr[2], leftArr[3])));
        result[3] = Math.max(rightArr[0], Math.max(rightArr[1], Math.max(rightArr[2], rightArr[3])));

        return result;
    }
}
