package jzoffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 与leetcode p54相同。
 *
 * @author Lam
 * @ClassName P29
 * @date 2020/6/17
 */
public class P29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m==0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] result = new int[m * n];

        spiral(matrix, 0, 0, m - 1, n - 1, result, 0);
        return result;
    }

    private void spiral(int[][] matrix, int top, int left, int down, int right, int[] result, int k) {
        if (top > down || left > right) {
            return;
        }

        if (top == down) {
            for (int i = left; i <= right; i++) {
                result[k++] = matrix[top][i];
            }
            return;
        } else if (left == right) {
            for (int i = top; i <= down; i++) {
                result[k++] = matrix[i][left];
            }
            return;
        }

        for (int i = left; i <= right; i++) {
            result[k++] = matrix[top][i];
        }

        for (int i = top + 1; i <= down; i++) {
            result[k++] = matrix[i][right];
        }

        for (int i = right - 1; i >= left; i--) {
            result[k++] = matrix[down][i];
        }

        for (int i = down - 1; i > top; i--) {
            result[k++] = matrix[i][left];
        }

        spiral(matrix, top + 1, left + 1, down - 1, right - 1, result, k);
    }
}
