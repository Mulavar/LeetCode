package jzoffer;

/**
 * 与主站p240相同
 *
 * @author Lam
 * @date 2020/6/30
 */
public class P4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }

        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j]==target) {
                return true;
            } else if (matrix[i][j]<target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
