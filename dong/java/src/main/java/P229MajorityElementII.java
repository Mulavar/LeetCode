import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * @author Lam
 * @ClassName P229MajorityElementII
 * @date 2020/1/31
 */
public class P229MajorityElementII {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int m1 = 0;
            int m2 = 0;
            int count1 = 0;
            int count2 = 0;
            int i = 0;

            ArrayList<Integer> result = new ArrayList<>();

            while (i < nums.length) {
                System.out.println("***m1:" + m1 + ", m2:" + m2 + ", num:" + nums[i]);

                if (count1 == 0 && nums[i] != m2) {
                    m1 = nums[i];
                    count1 = 1;
                } else if (nums[i] == m1) {
                    count1++;
                } else if (count2 == 0 && nums[i] != m1) {
                    m2 = nums[i];
                    count2 = 1;
                } else if (nums[i] == m2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
                i++;
            }

            if (isMajority(nums, m1)) {
                result.add(m1);
            }

            if (m1 != m2 && isMajority(nums, m2)) {
                result.add(m2);
            }

            System.out.println("m1:" + m1 + ", m2:" + m2);
            return result;
        }

        //note：可对分支判断优化如下
        public List<Integer> majorityElement1(int[] nums) {
            int m1 = 0;
            int m2 = 1;
            int count1 = 0;
            int count2 = 0;
            int i = 0;

            ArrayList<Integer> result = new ArrayList<>();

            while (i < nums.length) {
                if (nums[i]==m1) {
                    count1++;
                } else if (nums[i] == m2) {
                    count2++;
                } else if (count1 == 0) {
                    m1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    m2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
                i++;
            }

            if (isMajority(nums, m1)) {
                result.add(m1);
            }

            if (m1 != m2 && isMajority(nums, m2)) {
                result.add(m2);
            }

            return result;
        }

        private boolean isMajority(int[] nums, int k) {
            int count = 0;
            for (int num :
                    nums) {
                if (num == k) {
                    count++;
                }
            }

            return count > nums.length / 3;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 2, 1, 1, 3};
        System.out.println(new P229MajorityElementII().new Solution().majorityElement(nums));
    }
}
