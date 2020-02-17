/**
 * @author Lam
 * @ClassName P376WiggleSubsequence
 * @date 2020/2/17
 */
public class P376WiggleSubsequence {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int result = nums.length;
            int idx = 0;
            int pre = 0;
            while (idx < nums.length - 1) {
                if (idx != 0) {
                    int temp = (nums[idx + 1] - nums[idx]) * (nums[idx] - pre);
                    if (temp < 0) {
                        pre = nums[idx];
                    } else {
                        result--;
                    }
                } else {
                    pre = nums[0];
                }
                idx++;
            }
            if (nums.length > 1 && nums[nums.length - 1] == pre) {
                result--;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new P376WiggleSubsequence().new Solution().wiggleMaxLength(nums));
    }
}
