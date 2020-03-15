import java.util.Stack;

/**
 * @author Lam
 * @ClassName P84LargestRectangleHistogram
 * @date 2020/1/27
 */
public class P84LargestRectangleHistogram {
    class Solution {
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
    }

    class Solution1 {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            //note：核心，利用栈找出 start 和 end
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
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(new P84LargestRectangleHistogram().new Solution().largestRectangleArea(heights));
    }
}
