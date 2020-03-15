/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @author Lam
 * @ClassName P287FindDuplicateNumber
 * @date 2020/2/3
 */
public class P287FindDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            int fast = nums[nums[0]];
            int slow = nums[0];
            // 假设移动了k次，则slow走了k=k1+k2步（k2为在环内走的步数），fast走了2*k步，
            // 设环一共长n，则 k1 + k2 = 2 * k - n,
            // n = k1 + k2
            while (fast != slow) {
                fast = nums[fast];
                fast = nums[fast];
                slow = nums[slow];
            }

            System.out.println("fast:" + fast);
            System.out.println("low:" + slow);
            int start = 0;
            while (start != fast) {
                fast = nums[fast];
                start = nums[start];
            }

            return start;
        }
    }

    public static void main(String[] args) {
        // 4,3 3,4 2,2  fast,slow
        // 2,0 3,3 start, fast
        int[] nums = new int[]{3, 1, 3, 4, 2};
        System.out.println(new P287FindDuplicateNumber().new Solution().findDuplicate(nums));

    }
}
