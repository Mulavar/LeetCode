import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P189RotateArray
 * @date 2020/1/31
 */
public class P189RotateArray {
    // 旋转法
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length);
            reverse(nums, 0, k);
            reverse(nums, k, nums.length);
        }

        private void reverse(int[] nums, int start, int end) {
            int mid = (start + end) / 2;
            int i = start;
            while (i < mid) {
                int tmp = nums[i];
                nums[i] = nums[start + end - i - 1];
                nums[start + end - i - 1] = tmp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new P189RotateArray().new Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
