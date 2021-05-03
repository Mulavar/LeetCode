import java.util.Arrays;

/**
 * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
 */
public class P689MaximumSum3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length;
        int[] sums = new int[length + 1];

//        sums[i] = (nums[0...i - 1])
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int maxSum = 0;
        // dp[i][j] 表示在 nums[0...j) 中 i 个子数组的最大和
        // dp[i][j] = max(dp[i-1][j-k] + sums[j]-sums[j-k], dp[i][k-1])
        int[][] dp = new int[4][length + 1];
        for (int i = 1; i < 4; i++) {
            for (int j = k; j <= nums.length; j++) {
                // 上面的 sums 长度 +1 是为了这里能够方便计算 sum(nums[0...k-1]) 这一段
                // sums[k] - sums[0]
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - k] + sums[j] - sums[j - k]);
                maxSum = dp[i][j];
            }
        }

        int[] result = new int[3];
        for (int i = 2; i >= 0; i--) {
            for (int j = k; j <= nums.length; j++) {
                // 这里需要注意 i+1
                if (dp[i + 1][j] == maxSum) {
                    result[i] = j - k;
                    maxSum -= (sums[j] - sums[j - k]);
                    break;
                }
            }
        }

        return result;
    }
}
