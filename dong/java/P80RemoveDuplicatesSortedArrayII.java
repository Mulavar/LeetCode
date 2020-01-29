import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P80RemoveDuplicatesSortedArrayII
 * @date 2020/1/29
 */
public class P80RemoveDuplicatesSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int cnt = 1;
            int duplicate = 1;
            if (nums.length <= 1) {
                return nums.length;
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] && duplicate == 2) {
                    continue;
                } else if (nums[i] == nums[i - 1]) {
                    duplicate++;
                } else {
                    duplicate = 1;
                }
                nums[cnt++] = nums[i];
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        new P80RemoveDuplicatesSortedArrayII().new Solution().removeDuplicates(nums);

        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
        new P80RemoveDuplicatesSortedArrayII().new Solution().removeDuplicates(nums1);
    }
}
