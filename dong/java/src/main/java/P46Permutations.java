import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author Lam
 * @date 2019/12/9
 */
public class P46Permutations {

    // Recursive
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = p(nums, nums.length);
            return result;
        }

        public List<List<Integer>> p(int[] nums, int len) {
            if (len == 0) {
                return new ArrayList<List<Integer>>();
            }
            if (len == 1) {
                List<List<Integer>> result = new ArrayList<List<Integer>>();
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(nums[0]);
                result.add(tmp);
                return result;
            }
            List<List<Integer>> result = p(nums, len - 1);
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = result.get(i);
                for (int j = 0; j < tmp.size(); j++) {
                    result.add(new ArrayList<Integer>(tmp));
                    result.get(result.size() - 1).add(j, nums[len - 1]);
                }
                tmp.add(nums[len - 1]);
            }
            return result;
        }
    }

    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, 0, result);
            return result;
        }

        public void backtrack(int[] nums, int idx, List<List<Integer>> result) {
            if (idx == nums.length) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int num :
                        nums) {
                    tmp.add(num);
                }
                result.add(tmp);
            }

            for (int i = idx; i < nums.length; i++) {
                swap(nums, idx, i);
                backtrack(nums, idx + 1, result);
                swap(nums, idx, i);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}