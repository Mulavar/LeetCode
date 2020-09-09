/**
 * 给你一个 2D 矩阵 matrix，请计算出从左上角 (row1, col1) 到右下角 (row2, col2) 组成的矩形中所有元素的和。
 * <p>
 * 矩阵 matrix 的值只能通过 update 函数来进行修改
 * 你可以默认 update 函数和 sumRegion 函数的调用次数是均匀分布的
 * 你可以默认 row1 ≤ row2，col1 ≤ col2
 *
 * @author Lam
 * @date 2020/9/7
 */
public class P308RangeSumQuery2DMutable {


    class NumMatrix {
        /**
         * 二维区间和+单点更新的问题
         * 分解成一维前缀和+单点更新 => 树状数组
         *
         * *******
         * 该解法只对第二维使用树状数组
         * *******
         */

        private int[][] matrix;
        private int[][] tree;
        private int m;
        private int n;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m <= 0) {
                return;
            }

            int n = matrix[0].length;
            this.m = m;
            this.n = n + 1;
            this.matrix = new int[m][n];

            tree = new int[this.m][this.n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.matrix[i][j] = matrix[i][j];
                }
            }
        }

        /**
         * 单点更新
         * O(logn)
         */
        public void update(int row, int col, int val) {
            int idx = col + 1;
            int delta = val - this.matrix[row][col];
            this.matrix[row][col] = val;

            // 单点更新
            while (idx < n) {
                tree[row][idx] += delta;
                idx += lowbit(idx);
            }
        }

        /**
         * 获取区间和，分解为 对每一行求区间和
         * O(m*logn)
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += query(i, col2 + 1) - query(i, col1);
            }
            return sum;
        }


        /**
         * 求第x行的前缀和[1,y]
         */
        private int query(int x, int y) {
            int sum = 0;

            while (y > 0) {
                sum += tree[x][y];
                y -= lowbit(y);
            }

            return sum;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }
}
