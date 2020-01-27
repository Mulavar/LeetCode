/**
 * @author Lam
 * @ClassName P31NextPermutation
 * @date 2020/1/25
 */
public class P31NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            boolean exist = false;
            int idx = -1;
            if (nums.length <= 1) {
                return;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                revert(nums, 0, nums.length - 1);
                return;
            }

            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    idx = i;
                    int newIdx = -1;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] <= nums[idx]) {
                            newIdx = j - 1;
                            break;
                        }
                    }
                    if (newIdx == -1) {
                        newIdx = nums.length - 1;
                    }
                    swap(nums, idx, newIdx);

                    revert(nums, idx + 1, nums.length - 1);
                    break;
                }
            }
        }

        public void revert(int[] nums, int start, int end) {
            for (int i = start; i < (start + end + 1) / 2; i++) {
                swap(nums, i, start + end - i);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        //2, 5, 4, 3, 1 -> 3, 1, 2, 4, 5

        new P31NextPermutation().new Solution().nextPermutation(new int[]{1, 2, 1, 3});
        new P31NextPermutation().new Solution().nextPermutation(new int[]{2, 5, 4, 3, 1});
    }
}
