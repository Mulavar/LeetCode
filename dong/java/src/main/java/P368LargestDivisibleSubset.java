import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 *
 * @author Lam
 * @ClassName P368LargestDivisibleSubset
 * @date 2020/2/7
 */
public class P368LargestDivisibleSubset {
    /**
     * dp[i]存 0-i 位置最长的子集
     */
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> dp = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(nums[i]);
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp.get(j).size() + 1 > curr.size()) {
                            curr = new ArrayList<>(dp.get(j));
                            curr.add(nums[i]);
                        }
                    }
                }
                dp.add(curr);
                if (curr.size() > result.size()) {
                    result = curr;
                }
            }

            return result;
        }
    }

    /**
     * dp[i]表示 0-i 最长子集的长度
     * path记录最长子集的位置
     */
    class Solution1 {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int[] dp = new int[len];
            int[] path = new int[len];
            int max = 0;
            int pos = 0;
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                path[i] = -1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                    pos = i;
                }
            }

            while (pos != -1) {
                result.add(nums[pos]);
                pos = path[pos];
            }

            Collections.reverse(result);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 8};
        System.out.println(new P368LargestDivisibleSubset().new Solution1().largestDivisibleSubset(nums));
    }
}
