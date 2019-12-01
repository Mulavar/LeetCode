import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    class Solution {
        // Solution1
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                if (maps.containsKey(target - nums[i])) {
                    result[0] = i < maps.get(target - nums[i]) ? i : maps.get(target - nums[i]);
                    result[1] = i > maps.get(target - nums[i]) ? i : maps.get(target - nums[i]);
                    return result;
                }
                maps.put(nums[i], i);
            }
            return result;
        }
    }
}