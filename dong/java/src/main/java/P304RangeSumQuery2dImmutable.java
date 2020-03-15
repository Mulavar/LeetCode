/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，
 * 该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * @author Lam
 * @ClassName P304RangeSumQuery2dImmutable
 * @date 2020/2/25
 */
public class P304RangeSumQuery2dImmutable {

}

class NumMatrix {
    int[][] matrixCache;

    public NumMatrix(int[][] matrix) {
        this.matrixCache = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrixCache[i][j] = matrixCache[i][j - 1] + matrixCache[i][j];
            }
        }

        for (int i = 1; i < matrixCache.length; i++) {
            for (int j = 0; j < matrixCache[0].length; j++) {
                matrixCache[i][j] += matrixCache[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return this.matrixCache[row2][col2];
        } else if (row1 == 0) {
            return this.matrixCache[row2][col2] - this.matrixCache[row2][col1 - 1];
        } else if (col1 == 0) {
            return this.matrixCache[row2][col2] - this.matrixCache[row1 - 1][col2];
        } else {
            return matrixCache[row2][col2] + matrixCache[row1 - 1][col1 - 1] - matrixCache[row2][col1 - 1] - matrixCache[row1 - 1][col2];
        }
    }
}