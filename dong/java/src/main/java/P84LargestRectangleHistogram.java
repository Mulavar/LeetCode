import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author Lam
 * @ClassName P84LargestRectangleHistogram
 * @date 2020/1/27
 */
public class P84LargestRectangleHistogram {
    // S = (end - start) * height[i]
    // end 和 start 为 height左右第一个高度小于height[i]的的位置坐标
    // 难点在于找出end 和 start
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = i;
            right[i] = i;
            int j = 0;
            // 使用暴力解法搜索左边和右边第一个不大于heights[i]的坐标
            for (j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    left[i] = j + 1;
                    break;
                }
            }

            if (j < 0) {
                left[i] = 0;
            }

            for (j = i + 1; j < len; j++) {
                if (heights[j] < heights[i]) {
                    right[i] = j - 1;
                    break;
                }
            }

            if (j == len) {
                right[i] = len - 1;
            }

        }

        int maxRectangle = 0;
        for (int i = 0; i < len; i++) {
            maxRectangle = Math.max(heights[i] * (right[i] - left[i] + 1), maxRectangle);
        }
        return maxRectangle;
    }

    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //note：核心，利用单调栈找出 start 和 end
        //  需要遍历两次，并记录，空间复杂度On
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int res = 0;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        //note：核心，利用单调栈，但需要注意使用的是递增单调栈还是递减单调栈，
        // 这里使用单调递增栈
        for (int i = 0; i < n + 2; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int cur = stack.pop();
                res = Math.max(newHeights[cur] * (i - stack.peek() - 1), res);
            }
            stack.push(i);
        }
        return res;
    }

}
