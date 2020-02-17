/**
 * @author Lam
 * @ClassName P45JumpGameII
 * @date 2020/2/17
 */
public class P45JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int result = 0;

            result++;
            int start = 0;
            int pos = nums[start];
            int nextStart = 1;
            while (start < nums.length) {
                if (start + pos >= nums.length - 1) {
                    return result;
                }
                int nextMaxPos = 0;
                int curMaxPos = start + pos;
                for (int i = nextStart; i <= curMaxPos; i++) {
                    if (nums[i] + i > nextMaxPos) {
                        start = i;
                        pos = nums[i];
                        nextMaxPos = start + pos;
                    }
                }
                nextStart = curMaxPos + 1;

                result++;
            }

            return result;
        }

        public int jump1(int[] nums) {
            int result = 0;

            int start = 0;
            int end = 0;
            while (end < nums.length-1) {
                int nextEnd = start + nums[start];
                for (int i = start; i <= end; i++) {
                    if (nums[i] + i > nextEnd) {
                        nextEnd = nums[i] + i;
                    }
                }
                start = end + 1;
                end = nextEnd;
                result++;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new P45JumpGameII().new Solution().jump(nums));
        System.out.println(new P45JumpGameII().new Solution().jump1(nums));
    }
}
