import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * @author Lam
 * @date 2020/9/7
 */
public class P354RussianDollEnvelopes {
    /**
     * 本质是一个二维的最长上升子序列（LIS、P300)问题
     * 先排序再按LIS的解法做
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 先按一维，再二维进行排序
        // 二维逆序是考虑到信封宽一样的情况下，先用高的，再用小的尝试更新的情况
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            }
            return e2[1] - e1[1];
        });

        int n = envelopes.length;

        // dp[i]存储len(LIS)==i时末尾最小信封高度
        int[] dp = new int[n + 1];

        // 目前最长子序列长度
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = count;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 等号很重要
                // 这里只比第二维，因为第一维envelopes永远大于dp
                if (dp[mid] >= envelopes[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (dp[left] < envelopes[i][1]) {
                // 找到更长的子序列，更新末尾信封高
                dp[++count] = envelopes[i][1];
            } else {
                dp[left] = envelopes[i][1];
            }
        }

        return count;
    }
}
