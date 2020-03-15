import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @ClassName P119PascalTriangleII
 * @date 2020/1/30
 */
//todo 可以利用二项式定理直接求解
public class P119PascalTriangleII {
    // 利用数组默认值为0，从后往前计算杨辉三角
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<Integer> result = new ArrayList<>();
            int[] row = new int[rowIndex + 1];
            if (rowIndex < 0) {
                return result;
            }

            row[0] = 1;
            for (int i = 0; i <= rowIndex; i++) {
                for (int j = i; j > 0; j--) {
                    row[j] += row[j - 1];
                }
            }

            for (int i = 0; i <= rowIndex; i++) {
                result.add(row[i]);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P119PascalTriangleII().new Solution().getRow(3));
    }
}
