/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，
 * 唯有一个数只会出现一次，找出这个数。
 *
 * @author Lam
 * @ClassName P540SingleElementInSortedArray
 * @date 2020/2/21
 */
public class P540SingleElementInSortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        left = mid + 2;
                    } else {
                        right = mid;
                    }
                } else {
                    if (nums[mid - 1] == nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return nums[right];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new P540SingleElementInSortedArray().new Solution().singleNonDuplicate(nums));
    }
}
