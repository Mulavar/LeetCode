import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
 * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
 *
 * @author Lam
 * @ClassName P1439FindTheKthSmallestSumOfAMatrixWithSortedRows
 * @date 2020/9/14
 */
public class P1439FindTheKthSmallestSumOfAMatrixWithSortedRows {
    /**
     * 采用最小堆解法，可参考P264，并增加下标去重
     */
    public int kthSmallest(int[][] mat, int k) {
        if (k <= 0) {
            return 0;
        }

        PriorityQueue<Sum> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.value));
        int m = mat.length;
        if (m == 0) {
            return 0;
        }
        int n = mat[0].length;

        Set<List<Integer>> seen = new HashSet<>();

        // 初始化队列
        int initSum = 0;
        List<Integer> initIndexes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            initSum += mat[i][0];
            initIndexes.add(0);
        }
        queue.offer(new Sum(initSum, initIndexes));

        // 循环k-1次，弹出前k-1个较小的和
        while (k > 1) {
            Sum curSum = queue.poll();
            int oldValue = curSum.value;
            for (int i = 0; i < m; i++) {
                if (curSum.indexes.get(i) < n - 1) {
                    curSum.indexes.set(i, curSum.indexes.get(i) + 1);

                    // 去重
                    if (!seen.contains(curSum.indexes)) {
                        // 更新和
                        curSum.value = oldValue + mat[i][curSum.indexes.get(i)] - mat[i][curSum.indexes.get(i) - 1];

                        queue.offer(new Sum(curSum.value, curSum.indexes));

                        // 不能直接放入引用
                        seen.add(new ArrayList<>(curSum.indexes));
                    }


                    // 回退指针
                    curSum.indexes.set(i, curSum.indexes.get(i) - 1);
                }
            }

            k--;
        }

        // 弹出第k小的和作为结果
        return queue.poll().value;
    }

    /**
     * 采用二分法，可参考P378
     */
    public int kthSmallest1(int[][] mat, int k) {
        int m = mat.length;
        if (m == 0 || k <= 0) {
            return 0;
        }

        int n = mat[0].length;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < m; i++) {
            leftSum += mat[i][0];
            rightSum += mat[i][n - 1];
        }

        int initSum = leftSum;

        // 对leftSum和rightSum使用二分查找
        while (leftSum < rightSum) {
            int midSum = leftSum + (rightSum - leftSum) / 2;

            // 这里需要用initSum而不是leftSum
            int count = smallerThanMid(mat, initSum, midSum, 0, k);
            if (count >= k) {
                rightSum = midSum;
            } else {
                leftSum = midSum + 1;
            }
        }

        return leftSum;
    }

    /**
     * 统计小于等于midSum的和个数
     */
    private int smallerThanMid(int[][] mat, int initSum, int midSum, int row, int k) {
        if (row == mat.length) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < mat[0].length; i++) {
            if (initSum + mat[row][i] - mat[row][0] <= midSum) {
                count += smallerThanMid(mat, initSum + mat[row][i] - mat[row][0], midSum, row + 1, k);
            }
            if (count >= k) {
                return count;
            }
        }

        return count;
    }

    class Sum {
        int value;
        List<Integer> indexes;

        public Sum(int value, List<Integer> indexes) {
            this.value = value;
            this.indexes = new ArrayList<>();
            for (int i = 0; i < indexes.size(); i++) {
                this.indexes.add(indexes.get(i));
            }
        }

    }
}
