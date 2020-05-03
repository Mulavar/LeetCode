import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        recursiveSpiral(result, matrix, 0, 0, m-1, matrix[0].length-1);
        return result;
    }

    public List<Integer> loopSpiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;

        int midX = m / 2;
        int midY = n / 2;
        boolean oddX = m % 2 != 0;
        boolean oddY = n % 2 != 0;
        recursiveSpiral(result, matrix, 0, 0, m-1, matrix[0].length-1);
        int kx = 0;
        int ky = 0;
        int sx = 0;
        int sy = 0;
        while (kx < midX && ky < midY) {
            int nx = sx;
            int ny = sy;
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[nx][ny++]);
            }
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[nx++][ny]);
            }
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[nx][ny--]);
            }
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[nx--][ny]);
            }
            sx++;
            sy++;
            m -= 2;
            n -= 2;
            kx++;
            ky++;
        }

        if (kx == midX && oddX) {
            int nx = sx;
            int ny = sy;
            for (int i = 0; i < n; i++) {
                result.add(matrix[nx][ny++]);
            }
        } else if (ky == midY && oddY) {
            int nx = sx;
            int ny = sy;
            for (int i = 0; i < m; i++) {
                result.add(matrix[nx++][ny]);
            }
        }

        return result;
    }

    public void recursiveSpiral(List<Integer> result, int[][] matrix, int sx, int sy, int dx, int dy) {
        int m = dx - sx;
        int n = dy - sy;
        if (m < 0 || n < 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i <= n; i++) {
                result.add(matrix[sx][sy++]);
            }
            return;
        } else if (n == 0) {
            for (int i = 0; i <= m; i++) {
                result.add(matrix[sx++][sy]);
            }
            return;
        }

        for (int i = sy; i < dy; i++) {
            result.add(matrix[sx][i]);
        }
        for (int i = sx; i < dx; i++) {
            result.add(matrix[i][dy]);
        }
        for (int i = dy; i > sy; i--) {
            result.add(matrix[dx][i]);
        }
        for (int i = dx; i > sx; i--) {
            result.add(matrix[i][sy]);
        }

        recursiveSpiral(result, matrix, sx+1, sy+1, dx-1, dy-1);
    }
}
