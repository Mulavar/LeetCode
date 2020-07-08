package jzoffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author Lam
 * @date 2020/7/5
 */
public class P21 {
    public int[] exchange(int[] nums) {
        int even = 0;
        int odd = nums.length - 1;

        while (even < odd) {
            while (even < odd && nums[even] % 2 == 1) {
                even++;
            }
            while (odd > even && nums[odd] % 2 == 0) {
                odd--;
            }

            if (odd>even) {
                int tmp = nums[odd];
                nums[odd--] = nums[even];
                nums[even++] = tmp;
            }
        }
        return nums;
    }
}
