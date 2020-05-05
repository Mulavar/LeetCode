import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，
 * 你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * @author Lam
 * @date 2020/5/5
 */
public class P560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += map.getOrDefault(sums[i] - k, 0);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }

        return result;
    }
}
