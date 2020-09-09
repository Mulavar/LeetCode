import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * <p>
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 *
 * @author Lam
 * @date 2020/9/7
 */
public class P363MaxSumRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 求数组的区间联系上到前缀和
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        // 起始列
        for (int start = 0; start < n; start++) {
            // 按行的前缀和
            // preSums[i]表示第i行 start-end这一段的前缀和
            int[] preSums = new int[m];

            // 终止列
            for (int end = start; end < n; end++) {

                // 有序存储前缀和
                List<Integer> array = new ArrayList<>();
                // 只取第一个元素的情况
                array.add(0);

                // preSums数组的前缀和
                // 即(0, start) -> (row, end) 的和
                int cum = 0;

                // 按行遍历
                for (int row = 0; row < m; row++) {
                    // 对每一行计算最新的前缀和
                    preSums[row] += matrix[row][end];
                    cum += preSums[row];

                    // pre[j] - pre[i] <= k (i<j)
                    // => pre[j] - k <= pre[i]
                    // 找到满足条件的最小的pre[i]
                    int idx = findBigCloset(array, cum - k);
                    if (idx < array.size()) {
                        // 更新结果
                        res = Math.max(cum - array.get(idx), res);
                        if (res == k) {
                            return k;
                        }
                    }

                    // 更新有序前缀和数组
                    insert(array, cum);
                }
            }
        }

        return res;
    }

    private int findBigCloset(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            Integer cur = list.get(mid);
            if (cur == num) {
                return mid;
            } else if (cur < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (list.get(left) < num) {
            return left + 1;
        }
        return left;
    }

    private void insert(List<Integer> list, int num) {
        int idx = findBigCloset(list, num);
        list.add(idx, num);
    }
}
