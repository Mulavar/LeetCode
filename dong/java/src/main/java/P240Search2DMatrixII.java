/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author Lam
 * @date 2020/5/24
 */
public class P240Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return findTarget(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    /**
     * 二分法
     */
    private boolean findTarget(int[][] matrix, int lx, int ly, int rx, int ry, int target) {
        if (lx > rx || ly > ry) {
            return false;
        }

        if (lx >= matrix.length || rx >= matrix.length || ly >= matrix[0].length || ry >= matrix[0].length) {
            return false;
        }

        int midX = lx + (rx - lx) / 2;
        int midY = ly + (ry - ly) / 2;


        if (matrix[midX][midY] == target) {
            return true;
        } else if ((lx != rx || ly != ry) && matrix[midX][midY] < target) {
            if (!findTarget(matrix, midX + 1, ly, rx, ry, target)) {
                return findTarget(matrix, lx, midY + 1, midX, ry, target);
            }
            return true;
        } else if ((lx != rx || ly != ry) && matrix[midX][midY] > target) {
            if (!findTarget(matrix, lx, ly, midX - 1, ry, target)) {
                return findTarget(matrix, midX, ly, rx, midY - 1, target);
            }
            return true;
        }

        return false;
    }


    /**
     * 二分的优化版本
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, target);
    }

    private boolean searchRec(int[][] matrix, int left, int up, int right, int down, int target) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right - left) / 2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(matrix, left, row, mid - 1, down, target) || searchRec(matrix, mid + 1, up, right, row - 1, target);
    }

    /**
     * 最优解法：找出对的遍历点（左下角或右上角）
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}
