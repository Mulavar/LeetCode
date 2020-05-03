/**
 * 给定一个正整数 n，
 * 生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        recursiveGenerateMatrix(result, 0, 0, n - 1, n - 1, 1);
        return result;
    }

    private void recursiveGenerateMatrix(int[][] matrix, int sx, int sy, int dx, int dy, int k) {
        int m = dx - sx;

        if (m < 0) {
            return;
        } else if (m == 0) {
            matrix[dx][dy] = k++;
            return;
        }
        for (int i = sy; i < dy; i++) {
            matrix[sx][i] = k++;
        }
        for (int i = sx; i < dx; i++) {
            matrix[i][dy] = k++;
        }
        for (int i = dy; i > sy; i--) {
            matrix[dx][i] = k++;
        }
        for (int i = dx; i > sx; i--) {
            matrix[i][sy] = k++;
        }
        recursiveGenerateMatrix(matrix, sx + 1, sy + 1, dx - 1, dy - 1, k);
    }
}
