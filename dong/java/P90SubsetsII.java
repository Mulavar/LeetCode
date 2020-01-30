import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @ClassName P90SubsetsII
 * @date 2020/1/30
 */
public class P90SubsetsII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            boolean[] marked = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(result, marked, 0, nums);
            return result;
        }

        private void backtrack(List<List<Integer>> result, boolean[] marked, int start, int[] nums) {
            if (start >= nums.length) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    if (marked[i]) {
                        list.add(nums[i]);
                    }
                }
                result.add(list);
                return;
            }

            int end = start + 1;
            while (end < nums.length && nums[end] == nums[start]) {
                end++;
            }

            //not contains nums[i]
            backtrack(result, marked, end, nums);

            for (int i = start; i < end; i++) {
                mark(start, i+1, marked,true);
                backtrack(result, marked, end, nums);
                mark(start, i+1, marked,false);
            }

        }

        private void mark(int start, int end, boolean[] marked, boolean flag) {
            for (int i = start; i < end; i++) {
                marked[i] = flag;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2};
        System.out.println(new P90SubsetsII().new Solution().subsetsWithDup(nums));

        int[] nums1 = new int[]{1, 1, 1, 2, 2, 3, 3};
        System.out.println(new P90SubsetsII().new Solution().subsetsWithDup(nums1));
    }
}
