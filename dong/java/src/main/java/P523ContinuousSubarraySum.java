import java.util.HashMap;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * @author Lam
 * @date 2020/5/5
 */
public class P523ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }

        // sums[i]是包含自己的前缀和
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        //方法1. 使用前缀和计算，需要判断k为0的特殊情况
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int tmpSum = sums[j] - sums[i] + nums[i];
//                if ((k == 0 && tmpSum == 0) || (k != 0 && tmpSum % k == 0)) {
//                    return true;
//                }
//            }
//        }

        //方法2. 使用Map优化，map的key记录sum对k求余后的值，map的value记录位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int key = k == 0 ? sums[i] : sums[i] % k;
            int idx = map.getOrDefault(key, -2);
            if (idx == -2) {
                map.put(key, i);
            } else if (i - idx >= 2) {
                return true;
            }
        }

        return false;
    }
}
