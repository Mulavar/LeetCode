import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class P698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return true;
        }

        nums = IntStream.of(nums)          // 变为 IntStream
                .boxed()           // 变为 Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 按自然序相反排序
                .mapToInt(Integer::intValue)       // 变为 IntStream
                .toArray();

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        if (target < nums[length - 1]) {
            return false;
        }

        boolean[] visited = new boolean[length];
        return backtrack(nums, target, target, k, 0, visited);
    }

    private boolean backtrack(int[] nums, int target, int rest, int k, int start, boolean[] visited) {
        if (k == 0) {
            return true;
        }

        if (nums[nums.length - 1] > rest) {
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            // ******核心去重逻辑******
            // 当碰到连续的两个数时，只取前一个和只取后一个计算路径是一样的，因此可以去重
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1] || visited[i]) {
                continue;
            }

            visited[i] = true;

            if (nums[i] == rest && backtrack(nums, target, target, k - 1, 0, visited)) {
                return true;
            }

            if (nums[i] < rest && backtrack(nums, target, rest - nums[i], k, i + 1, visited)) {
                return true;
            }

            visited[i] = false;
        }

        return false;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return true;
        }

        nums = IntStream.of(nums)          // 变为 IntStream
                .boxed()           // 变为 Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 按自然序相反排序
                .mapToInt(Integer::intValue)       // 变为 IntStream
                .toArray();

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        if (target < nums[length - 1]) {
            return false;
        }

        return dfs(nums, 0, new int[k], k, target);
    }

    /**
     * 基本思路是把数组 nums 的数分到 k 个抽屉里，每个抽屉累积分到的数的和，
     * 再利用回溯法计算是否能分完。
     * @param nums 源数组
     * @param idx 源数组目前要放进抽屉的数
     * @param groups 抽屉
     * @param k 抽屉个数
     * @param target 目标值
     * @return 是否成功
     */
    private boolean dfs(int[] nums, int idx, int[] groups, int k, int target) {
        if (idx == nums.length) {
            return true;
        }

        // 遍历查看 nums[i] 能放进哪个抽屉
        for (int i = 0; i < k; i++) {
            groups[i] += nums[idx];

            if (groups[i] <= target) {
                if (dfs(nums, idx + 1, groups, k, target)) {
                    return true;
                }
            }

            groups[i] -= nums[idx];

            // 若等于0，说明剩下的数无法凑成目标值，直接退出
            if (groups[i] == 0) {
                break;
            }
        }

        return false;
    }
}
