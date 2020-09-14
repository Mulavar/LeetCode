/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * @author Lam
 * @ClassName P378KthSmallestElementInASortedMatrix
 * @date 2020/9/14
 */
public class P378KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0 || k <= 0) {
            return 0;
        }
        int n = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = smallerThanTarget(matrix, mid);
//            System.out.println("left:" + left + ", mid:" + mid + ", right:" + right + ", count:" + count);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 统计小于等于target的元素个数
     */
    private int smallerThanTarget(int[][] matrix, int target) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            count += matrix[i][left] <= target ? left + 1 : left;
        }

        return count;
    }
}
