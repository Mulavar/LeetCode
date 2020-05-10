/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author Lam
 * @date 2020/5/11
 */
public class P74Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0 || matrix[0].length==0) {
            return false;
        }

        int i = 0;
        int j = rows - 1;

        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }

        int midRow = i;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target == matrix[midRow][mid]) {
                return true;
            } else if (target < matrix[midRow][mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return matrix[midRow][left] == target ? true : false;
    }
}
