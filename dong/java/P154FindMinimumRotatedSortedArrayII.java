/**
 * @author Lam
 * @ClassName P154FindMinimumRotatedSortedArrayII
 * @date 2020/1/30
 */
public class P154FindMinimumRotatedSortedArrayII {
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
