/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *
 * @author Lam
 * @ClassName P31NextPermutation
 * @date 2020/1/25
 */
public class P31NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean exist = false;
        int idx = -1;
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                exist = true;
                break;
            }
        }

        // 如果是降序排列，则改为升序排列
        if (!exist) {
            revert(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            // 找到第一个升序的位置
            if (nums[i] < nums[i + 1]) {
                idx = i;
                int newIdx = -1;
                // 在后面序列找到大于nums[i]的最小值
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] <= nums[idx]) {
                        newIdx = j - 1;
                        break;
                    }
                }
                if (newIdx == -1) {
                    newIdx = nums.length - 1;
                }
                swap(nums, idx, newIdx);

                revert(nums, idx + 1, nums.length - 1);
                break;
            }
        }
    }

    public void revert(int[] nums, int start, int end) {
        for (int i = start; i < (start + end + 1) / 2; i++) {
            swap(nums, i, start + end - i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
