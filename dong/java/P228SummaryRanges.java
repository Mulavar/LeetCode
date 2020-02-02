import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P228SummaryRanges
 * @date 2020/2/2
 */
public class P228SummaryRanges {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            ArrayList<String> result = new ArrayList<>();
            if (nums.length == 0) {
                return result;
            }

            int start = nums[0];
            int end = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i] + 1) {
                    end = nums[i + 1];
                } else {
                    result.add(start == end ? String.valueOf(start) : start + "->" + end);
                    start = nums[i + 1];
                    end = start;
                }
            }
            result.add(start == end ? String.valueOf(start) : start + "->" + end);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(new P228SummaryRanges().new Solution().summaryRanges(nums));
    }
}
