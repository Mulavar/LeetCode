import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * @author Lam
 * @date 2020/5/18
 */
public class P164MaximumGap {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        // 排序后遍历
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public int maximumGap1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int maxElem = 0;
        for (int i = 0; i < n; i++) {
            maxElem = Math.max(maxElem, nums[i]);
        }
        int exp = 1;
        int[] aux = new int[n];

        while (maxElem >= exp) {
            //counting sort
            int[] count = new int[10];
            for (int i = 0; i < n; i++) {
                count[nums[i] / exp % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                aux[--count[nums[i] / exp % 10]] = nums[i];
            }

            for (int i = 0; i < n; i++) {
                nums[i] = aux[i];
            }
            exp *= 10;

        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
