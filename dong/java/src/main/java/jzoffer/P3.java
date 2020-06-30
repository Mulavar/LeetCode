package jzoffer;

import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @author Lam
 * @date 2020/6/30
 */
public class P3 {
    public int findRepeatNumber(int[] nums) {
        int idx = 0;
        int n = nums.length;
        while (idx < n) {
            if (idx>nums[idx]) {
                return nums[idx];
            } else if (idx<nums[idx]) {
                int tmp = nums[nums[idx]];
                if (nums[idx]==tmp) {
                    return tmp;
                }
                nums[nums[idx]] = nums[idx];
                nums[idx] = tmp;
            } else {
                idx++;
            }
        }
        return -1;
    }
}
