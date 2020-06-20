package jzoffer;


/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P57 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }
}
