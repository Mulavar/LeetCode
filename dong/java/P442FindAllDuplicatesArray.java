import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P442FindAllDuplicatesArray
 * @date 2020/1/31
 */
public class P442FindAllDuplicatesArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i] <= 0 ? nums[i] + nums.length - 1 : nums[i] - 1;
                if (nums[val] <= 0) {
                    result.add(val + 1);
                    continue;
                }
                nums[val] -= nums.length;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        System.out.println(new P442FindAllDuplicatesArray().new Solution().findDuplicates(nums));
    }
}
