import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * @author Lam
 * @date 2020/5/8
 */
public class P377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n && nums[j] <= i; j++) {
                if (nums[j] == i) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
