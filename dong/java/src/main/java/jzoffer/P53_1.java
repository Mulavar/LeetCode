package jzoffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Lam
 * @date 2020/6/18
 */
public class P53_1 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int idx = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == right && nums[left] == target) {
            idx = left;
        }

        if (idx == -1) {
            return 0;
        }

        int result = 1;
        int i = idx + 1;
        while (i < n && nums[i++] == target) {
            result++;
        }

        i = idx - 1;
        while (i >= 0 && nums[i--] == target) {
            result++;
        }

        return result;
    }

    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

}
