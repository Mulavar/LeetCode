/**
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * @author Lam
 * @ClassName P327CountRangeSum
 * @date 2020/3/22
 */
public class P327CountRangeSum {
    /**
     * 前缀和+归并
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }
        return merge(sum, lower, upper, 0, n);
    }

    private int merge(long[] nums, int lower, int upper, int left, int right) {
        if (right <= left) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int lr = merge(nums, lower, upper, left, mid);
        int rr = merge(nums, lower, upper, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = 0;
        long[] tmp = new long[right - left + 1];


        int lp = left;
        int rlp = mid + 1;
        int rrp = mid + 1;
        int result = lr + rr;
        while (lp <= mid) {
            while (rlp <= right && nums[rlp] - nums[lp] < lower) {
                rlp++;
            }
            while (rrp <= right && nums[rrp] - nums[lp] <= upper) {
                rrp++;
            }

            result += rrp - rlp;
            lp++;
        }

        while (i <= mid || j <= right) {
            if (i > mid) {
                tmp[k++] = nums[j++];
            } else if (j > right) {
                tmp[k++] = nums[i++];
            }
            if (i <= mid && j <= right) {
                if (nums[i] < nums[j]) {
                    tmp[k++] = nums[i++];
                } else {
                    tmp[k++] = nums[j++];
                }
            }
        }

        k = 0;
        for (i = left; i <= right; i++) {
            nums[i] = tmp[k++];
        }
        return result;
    }
}
