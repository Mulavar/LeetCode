import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P216CombinationSumIII
 * @date 2020/1/31
 */
public class P216CombinationSumIII {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), 1, 0, k, n);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> combinations, int num, int count, int k, int n) {
            if (count == k) {
                if (n == 0) {
                    result.add(new ArrayList<>(combinations));
                }
                return;
            } else if (n <= 0 || num > 9) {
                return;
            }

            combinations.add(num);
            backtrack(result, combinations, num + 1, count + 1, k, n - num);
            combinations.remove(combinations.size() - 1);
            backtrack(result, combinations, num + 1, count, k, n);
        }
    }

    class Solution1 {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), 1, 0, k, n);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> combinations, int num, int count, int k, int n) {
            if (count == k) {
                if (n == 0) {
                    result.add(new ArrayList<>(combinations));
                }
                return;
            } else if (n <= 0 || num > 9) {
                return;
            }

            for (int i = num; i < 10; i++) {
                combinations.add(i);
                backtrack(result, combinations, i + 1, count + 1, k, n - i);
                combinations.remove(combinations.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P216CombinationSumIII().new Solution().combinationSum3(3, 7));
        System.out.println(new P216CombinationSumIII().new Solution1().combinationSum3(3, 7));
    }
}
