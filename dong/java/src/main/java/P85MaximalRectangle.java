import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * @author Lam
 * @date 2020/5/14
 */
public class P85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] heights = new int[m + 2][n];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m + 1) {
                    heights[i][j] = 0;
                } else if (j == 0) {
                    heights[i][j] = matrix[i - 1][j] == '1' ? 1 : 0;
                } else {
                    heights[i][j] = matrix[i - 1][j] == '1' ? heights[i][j - 1] + 1 : 0;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            stack.clear();
            for (int j = 0; j < m + 2; j++) {
                //note：每次i是固定的，所以可以删去i优化为一维数组
                while (!stack.isEmpty() && heights[j][i] < heights[stack.peek()][i]) {
                    int cur = stack.pop();
                    res = Math.max(res, heights[cur][i] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        return res;
    }

    // 对上述的空间优化
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int res = 0;
        int[] heights = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            stack.clear();
            stack.push(-1);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = i == 0 ? 1 : heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
                while (stack.size()>1 && heights[stack.peek()] > heights[j]) {
                    int cur = stack.pop();
                    res = Math.max(res, heights[cur] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (stack.size() > 1) {
                int cur = stack.pop();
                res = Math.max(res, heights[cur] * (n - stack.peek() - 1));
            }
        }
        return res;
    }
}
