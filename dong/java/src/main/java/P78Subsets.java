import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @date 2019/12/8
 */
public class P78Subsets {
    /**
     * 使用回溯法
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            int len = nums.length;
            boolean[] marked = new boolean[len];

            makeResult(result, null, 0, nums, marked);
            return result;
        }

        public void makeResult(List<List<Integer>> result, List<Integer> tmp, int cnt, int[] nums, boolean[] marked) {
            if (cnt == nums.length) {
                tmp = new ArrayList<Integer>();
                for (int i = 0; i < nums.length; i++) {
                    if (marked[i]) {
                        tmp.add(nums[i]);
                    }
                }
                result.add(tmp);
                return;
            }

            marked[cnt] = true;
            makeResult(result, tmp, cnt + 1, nums, marked);
            marked[cnt] = false;
            makeResult(result, tmp, cnt + 1, nums, marked);
        }
    }

    /**
     * 不使用回溯法
     */
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            // 增加空集
            result.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    // 不含nums[i]的子集
                    result.add(new ArrayList<>(result.get(j)));
                    // 含有nums[i]的子集
                    result.get(j).add(nums[i]);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P78Subsets.Solution p72SubSets = new P78Subsets().new Solution();
        List<List<Integer>> subsets = p72SubSets.subsets(nums);
        System.out.println(subsets);

    }

}
