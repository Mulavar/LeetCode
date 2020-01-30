import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P118PascalTriangle
 * @date 2020/1/30
 */
public class P118PascalTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<Integer> firstRow = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            if (numRows == 0) {
                return result;
            }

            firstRow.add(1);
            result.add(firstRow);
            if (numRows == 1) {
                return result;
            }

            for (int i = 1; i < numRows; i++) {
                List<Integer> newRow = new ArrayList<>();
                List<Integer> lastRow = result.get(i - 1);
                newRow.add(1);
                int j = 0;
                while (j < lastRow.size() - 1) {
                    newRow.add(lastRow.get(j) + lastRow.get(j + 1));
                    j++;
                }
                newRow.add(1);
                result.add(newRow);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P118PascalTriangle().new Solution().generate(1));
        System.out.println(new P118PascalTriangle().new Solution().generate(2));
        System.out.println(new P118PascalTriangle().new Solution().generate(3));
    }
}
