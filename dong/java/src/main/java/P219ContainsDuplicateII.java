import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * @author Lam
 * @date 2020/5/24
 */
public class P219ContainsDuplicateII {
    /**
     * 边界条件可能有问题(k==Integer.MAX_VALUE)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int oldIdx = map.getOrDefault(nums[i], -(k + 1));
            if (i - oldIdx <= k) {
                return true;
            }
            map.put(nums[i], i);

        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            if (map.put(nums[right], right) != null) {
                return true;
            }
            if (map.size() > k) {
                map.remove(nums[right - k]);
            }
        }
        return false;
    }
}
