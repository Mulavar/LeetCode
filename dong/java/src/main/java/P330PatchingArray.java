/**
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。
 * 从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
 * 请输出满足上述要求的最少需要补充的数字个数。
 *
 * @author Lam
 * @date 2020/9/8
 */
public class P330PatchingArray {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int i = 0;
        int count = 0;
        while (missing < n) {
            if (i < nums.length && missing >= nums[i]) {
                missing += nums[i++];
            } else {
                missing += missing;
                count++;
            }
        }

        return count;
    }
}
