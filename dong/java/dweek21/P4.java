package dweek21;

import bean.TreeNode;

/**
 * @author Lam
 * @ClassName P4
 * @date 2020/3/7
 */
public class P4 {
    private int min = -50000;
    private int max = 50000;

    public int maxSumBST(TreeNode root) {
        int[] arr = calc(root);
        return Math.max(0, Math.max(arr[1], Math.max(arr[2], arr[3])));
    }

    // 0 bool 1 root 2 non-root 3 min 4 max
    private int[] calc(TreeNode root) {
        if (root == null) {
            return new int[]{1, min, min, max, min};
        } else if (root.left == null && root.right == null) {
            return new int[]{1, root.val, root.val, root.val, root.val};
        }

        int[] leftArr = calc(root.left);
        int[] rightArr = calc(root.right);
        int maxLSum = Math.max(leftArr[1], leftArr[2]) == min ? 0 : Math.max(leftArr[1], leftArr[2]);
        int maxRSum = Math.max(rightArr[1], rightArr[2]) == min ? 0 : Math.max(rightArr[1], rightArr[2]);
        //root need to > left max  root need to < right min
        if (leftArr[0] == 0 || rightArr[0] == 0 || root.val <= leftArr[4] || root.val >= rightArr[3]) {
            return new int[]{0, 0, Math.max(maxLSum, maxRSum), 0, 0};
        }

        int leftSum = leftArr[1]==min?0:leftArr[1];
        int rightSum = rightArr[1]==min?0:rightArr[1];
        int sum = leftSum + rightSum + root.val;
        int maxSum = Math.max(sum, Math.max(maxLSum, maxRSum));
        int[] result = {1, sum, maxSum, Math.min(leftArr[3], root.val), Math.max(rightArr[4], root.val)};
        return result;
    }

    int maxsum = 0;
    int maxSumBST1(TreeNode root) {
        if (root==null) return 0;
        int[] sum = new int[1];
        boolean ret = func(root, sum);
        if (!ret) return maxsum;
        if (root.left!=null && root.val <= root.left.val) return maxsum;
        if (root.right!=null && root.val >= root.right.val) return maxsum;
        return Math.max(maxsum, sum[0]);
    }

    boolean func(TreeNode root, int[] sum) {
        if (root==null) return true;
        int[] lsum = new int[]{0};
        int[] rsum = new int[]{0};
        sum[0] = 0;
        boolean lret = func(root.left, lsum);
        boolean rret = func(root.right, rsum);
        if (!lret || !rret) {
            sum[0] = 0;
            return false;
        }
        if (root.left!=null && root.val <= root.left.val) return false;
        if (root.right!=null && root.val >= root.right.val) return false;
        sum[0] += root.val;
        sum[0] += lsum[0];
        sum[0] += rsum[0];
        maxsum = Math.max(sum[0], maxsum);
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(-5);
        root.left.right.right = new TreeNode(4);
        root.left.right.left.right = new TreeNode(-3);
        root.left.right.right.right = new TreeNode(10);

        System.out.println(root);
        System.out.println(new P4().maxSumBST(root));


        TreeNode root1 = new TreeNode(9);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(10);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(11);
        System.out.println(new P4().maxSumBST1(root1));
        System.out.println(new P4().maxSumBST(root1));

    }
}
