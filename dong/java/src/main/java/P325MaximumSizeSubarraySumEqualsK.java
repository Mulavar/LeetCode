import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 *
 * @author Lam
 * @date 2020/7/18
 */
public class P325MaximumSizeSubarraySumEqualsK {
    /**
     * 优化后的算法，对前缀和只存最左边出现的位置，
     * 然后从右扫描只找value - k的位置，
     * 计算得到最长子数组长度
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int max = 0;

        // 求前缀和，并利用 Map<前缀和, 对应索引> 储存
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= len; i ++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (!map.containsKey(sum[i]))
                map.put(sum[i], i);
        }

        // 从后向前遍历数组，i为子数组的结尾，寻找符合条件的前缀和及其索引
        for (int i = len; i > max; i --) {
            if (map.containsKey(sum[i] - k)) {
                max = Math.max(max, i - map.get(sum[i] - k));
            }
        }
        return max;
    }

    /**
     * 记录每个前缀和其位置的映射，
     * 扫描前缀和preSum, 对每个值value找 value + k 和 value - k的位置，
     * 计算得到最长子数组长度
     */
    public int maxSubArrayLen1(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        Map<Integer, Bound> map = new HashMap<>();

        // 构造前缀和
        for (int i = 0; i <= n; i++) {
            preSum[i] = i == 0 ? 0 : preSum[i - 1] + nums[i - 1];

            // 存储每个值出现最左最右的位置
            Bound bound = map.getOrDefault(preSum[i], new Bound(i, i));
            bound.left = bound.left < i ? bound.left : i;
            bound.right = bound.right > i ? bound.right : i;
            map.put(preSum[i], bound);
        }


        int result = 0;
        for (int i = 0; i <= n; i++) {
            int key = preSum[i];

            Bound minBound = map.getOrDefault(key - k, new Bound(i, i));
            result = Math.max(result, i - minBound.left);

            Bound maxBound = map.getOrDefault(key + k, new Bound(i, i));
            result = Math.max(result, maxBound.right - i);
        }

        return result;
    }

    class Bound {
        int left;
        int right;

        public Bound(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Bound{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
