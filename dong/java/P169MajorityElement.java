/**
 * @author Lam
 * @ClassName P169MajorityElement
 * @date 2020/1/29
 */
public class P169MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int elem = nums[0];
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != elem && count >= 0) {
                    count--;
                } else if (nums[i] != elem) {
                    elem = nums[i];
                } else {
                    count++;
                }
            }
            return elem;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(new P169MajorityElement().new Solution().majorityElement(nums));
    }
}
