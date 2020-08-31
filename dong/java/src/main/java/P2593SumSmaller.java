import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target，
 * 寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 * @author Lam
 * @date 2020/8/30
 */
public class P2593SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int cur = nums[i] + nums[left] + nums[right];
                if (cur >= target) {
                    right--;
                } else {
                    // todo 只能处理允许重复的情况
                    result += (right - left++);
                }
            }
        }

        return result;
    }
}
