import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P38CombinationSum
 * @date 2020/1/27
 */
public class P39CombinationSum {
    // backtrace算法
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            solve(result, new ArrayList<Integer>(), candidates, 0, target);
            return result;
        }

        private void solve(List<List<Integer>> result, List<Integer> nums, int[] candidates, int i, int target) {
            if (target == 0) {
                result.add(new ArrayList<>(nums));
                return;
            } else if (target < 0 || i >= candidates.length) {
                return;
            }

            // add candidates[i]
            nums.add(candidates[i]);
            solve(result, nums, candidates, i, target - candidates[i]);
            // remove candidates[i]
            nums.remove(nums.size() - 1);
            solve(result, nums, candidates, i + 1, target);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(new P39CombinationSum().new Solution().combinationSum(candidates, target));
    }
}
