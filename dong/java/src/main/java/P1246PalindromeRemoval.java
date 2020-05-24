import java.util.Arrays;

/**
 * 给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。
 * 注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。
 * 请你计算并返回从数组中删除所有数字所需的最少操作次数。
 *
 * @author Lam
 * @date 2020/5/20
 */
public class P1246PalindromeRemoval {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                dp[i][i + len] = len + 1;
                for (int j = i ; j < i + len; j++) {
                    dp[i][i + len] = Math.min(dp[i][i + len], dp[i][j] + dp[j + 1][i + len]);
                }
                if (arr[i] == arr[i + len]) {
                    dp[i][i + len] = Math.min(dp[i][i + len], dp[i + 1][i + len - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 14, 18, 20, 14};
        System.out.println(new P1246PalindromeRemoval().minimumMoves(arr));
    }
}
