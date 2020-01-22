/**
 * @author Lam
 * @ClassName P26RemoveDuplicatesSortedArray
 * @date 2020/1/20
 */
public class P26RemoveDuplicatesSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int result = nums.length;
            int k = 1;
            if (result < 1) {
                return result;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    result--;
                } else {
                    nums[k++] = nums[i];
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        new P26RemoveDuplicatesSortedArray().new Solution().removeDuplicates(new int[]{1, 1, 2});
    }
}
