import bean.TreeNode;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
 * 注意:
 * 子树必须包含其所有后代。
 *
 * @author Lam
 * @date 2020/7/18
 */
public class P333LargestBstSubtree {
    private Result result = new Result(true, 0, 0, 0);

    /**
     * 通过后续遍历，回传有效信息进行判断
     */
    public int largestBSTSubtree(TreeNode root) {
        Result rootResult = postOrder(root);
        return rootResult.bst && rootResult.num > result.num ? rootResult.num : result.num;
    }

    private Result postOrder(TreeNode root) {
        if (root == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result leftResult = postOrder(root.left);
        Result rightResult = postOrder(root.right);

        result = leftResult.bst && leftResult.num >= result.num ? leftResult : result;
        result = rightResult.bst && rightResult.num >= result.num ? rightResult : result;

        // 当左右子树都是BST时，才可能是BST
        if (leftResult.bst && rightResult.bst) {
            // 比较当前结点值是否大于左子树最大值且小于右子树最小值
            if (root.val > leftResult.maxNum && root.val < rightResult.minNum) {
                int minNum = root.left == null ? root.val : leftResult.minNum;
                int maxNum = root.right == null ? root.val : rightResult.maxNum;
                return new Result(true, leftResult.num + rightResult.num + 1, minNum, maxNum);
            }
        }

        return new Result(false, 0, 0, 0);
    }


    class Result {
        /**
         * 标记该树是否是BST
         */
        boolean bst;
        /**
         * 标记该子树结点个数
         */
        int num;
        /**
         * 该子树最小值，用于给父结点判断是否是BST
         */
        int minNum;
        /**
         * 该子树最大值，用于给父结点判断是否是BST
         */
        int maxNum;

        public Result(boolean bst, int num, int minNum, int maxNum) {
            this.bst = bst;
            this.num = num;
            this.minNum = minNum;
            this.maxNum = maxNum;
        }
    }

}
