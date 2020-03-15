/**
 * @author Lam
 * @ClassName P41FirstMissingPositive
 * @date 2020/1/26
 */
public class P41FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                if (nums[i] <= 0) {
                    nums[i] = size + 100;
                }
            }

            for (int i = 0; i < size; i++) {
                int num = nums[i] < 0 ? 0 - nums[i] : nums[i];
                if (num > size) {
                    continue;
                }
                if (nums[num-1]>0) {
                    nums[num - 1] = 0 - nums[num - 1];
                }

            }

            for (int i = 0; i < size; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return size + 1;
        }
    }
}
