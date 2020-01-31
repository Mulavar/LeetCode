/**
 * @author Lam
 * @ClassName P153FindMinimumRotatedSortedArray
 * @date 2020/1/30
 */
public class P153FindMinimumRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int idx = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    idx = i;
                    break;
                }
            }
            return nums[idx];
        }
    }
}
