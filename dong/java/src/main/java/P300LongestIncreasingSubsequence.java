/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * @author Lam
 * @date 2020/9/4
 */
public class P300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // lens[i]表示以nums[i]为末尾的最长子序列长度
        int[] lens = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lens[i] = Math.max(lens[i], lens[j]);
                }
            }
            result = Math.max(result, ++lens[i]);
        }

        return result;
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;

        // dp[i]表示最长子序列长度为i的末尾最小数字
        // 易得dp[i+1]>dp[i]
        int[] dp = new int[n + 1];
        // 表示当前已找到的最长序列长度
        int count = 0;
        dp[count] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // 找0~count范围内第一个大于nums[i]的位置
            int left = 0;
            int right = count;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid]<nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 所有值都小于nums[i]
            if (dp[left]<nums[i]) {
                dp[++count] = nums[i];
            } else {
                dp[left] = nums[i];
            }

        }

        return count;
    }
}
