import java.util.Arrays;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 *
 * @author Lam
 * @date 2020/6/4
 */
public class P312BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = 1;
        arr[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 1; len++) {
            for (int i = 0; i < n + 2 - len; i++) {
                for (int j = i + 1; j < i + len; j++) {
                    dp[i][i + len] = Math.max(dp[i][i + len], arr[i] * arr[i + len] * arr[j] + dp[i][j] + dp[j][i + len]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][n + 1];
    }
}
