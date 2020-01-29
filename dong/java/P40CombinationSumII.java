import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lam
 * @ClassName P40CombinationSumII
 * @date 2020/1/27
 */
public class P40CombinationSumII {
    // 使用Set做去重
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> result = new HashSet<>();
            solve(result, new ArrayList<Integer>(), candidates, 0, target);
            return new ArrayList<>(result);
        }

        private void solve(Set<List<Integer>> result, List<Integer> nums, int[] candidates, int i, int target) {
            System.out.println("i: " + i + ", target: " + target);
            if (target == 0) {
                ArrayList<Integer> singleRes = new ArrayList<>(nums);
                Collections.sort(singleRes);
                result.add(singleRes);
                return;
            } else if (target < 0 || i >= candidates.length) {
                return;
            }

            // add candidates[i]
            nums.add(candidates[i]);
            solve(result, nums, candidates, i + 1, target - candidates[i]);
            // remove candidates[i]
            nums.remove(nums.size() - 1);
            solve(result, nums, candidates, i + 1, target);
        }
    }

    // 先排序再去重
    class Solution1 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Set<List<Integer>> result = new HashSet<>();
            Arrays.sort(candidates);
            solve(result, new ArrayList<Integer>(), candidates, 0, target);
            return new ArrayList<>(result);
        }

        private void solve(Set<List<Integer>> result, List<Integer> nums, int[] candidates, int i, int target) {
            if (target == 0) {
                ArrayList<Integer> singleRes = new ArrayList<>(nums);
                Collections.sort(singleRes);
                result.add(singleRes);
                return;
            } else if (target < 0 || i >= candidates.length) {
                return;
            }

            // add candidates[i]
            nums.add(candidates[i]);
            solve(result, nums, candidates, i + 1, target - candidates[i]);
            // remove candidates[i] and we need to move i to next element
            // that not equal with candidates[i]
            nums.remove(nums.size() - 1);
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                i++;
            }
            solve(result, nums, candidates, i + 1, target);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new P40CombinationSumII().new Solution().combinationSum2(candidates, target));
    }
}
