/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author Lam
 * @ClassName P42RrappingRainWater
 * @date 2020/9/19
 */
public class P42RrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n==0) {
            return 0;
        }

        // 每个柱子位置能接的水是 左右柱子最高高度的的最小值 - 当前柱子高度
        int left = 0;
        int right = n - 1;

        // 记录左右柱子最高高度
        int lMax = height[left];
        int rMax = height[right];

        int result = 0;
        // 双指针遍历
        while (left + 1 < right) {
            while (left + 1 < right && lMax < rMax) {
                left++;
                if (height[left] < lMax) {
                    result += lMax - height[left];
                } else {
                    // 更新左边柱子最高高度
                    lMax = height[left];
                }
            }

            while (left + 1 < right && lMax >= rMax) {
                right--;
                if (height[right] < rMax) {
                    result += rMax - height[right];
                } else {
                    // 更新右边柱子最高高度
                    rMax = height[right];
                }
            }
        }

        return result;
    }
}
