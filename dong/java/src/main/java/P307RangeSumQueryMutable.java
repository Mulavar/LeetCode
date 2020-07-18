import java.util.Arrays;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * @author Lam
 * @date 2020/7/18
 */
public class P307RangeSumQueryMutable {
    // 本质是树状数组和线段树的应用

    /**
     * 树状数组实现
     */
    public class NumArray {
        int[] source;
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            this.n = nums.length + 1;
            this.tree = new int[this.n + 1];
            this.source = new int[nums.length];

            // 先更新树状数组（树状数组的更新需要增量）
            for (int i = 0; i < nums.length; i++) {
                this.update(i, nums[i]);
            }

            // 记录原数组的值，方便更新时获取到增量
            System.arraycopy(nums, 0, source, 0, nums.length);
        }

        public void update(int i, int val) {
            // 先计算增量
            int moment = val - source[i];
            source[i] = val;

            // 更新树状数组
            updateTree(i + 1, moment);
        }

        /**
         * 计算i到j的区间和，包含i，j位置
         */
        public int sumRange(int i, int j) {
            return query(j + 1) - query(i);
        }

        /** 树状数组的区间查询、单点更新逻辑 */

        private void updateTree(int i, int val) {
            while (i <= n) {
                tree[i] += val;
                i += lowbit(i);
            }
        }

        private int query(int i) {
            int result = 0;
            while (i > 0) {
                result += tree[i];
                i -= lowbit(i);
            }
            return result;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }
}
