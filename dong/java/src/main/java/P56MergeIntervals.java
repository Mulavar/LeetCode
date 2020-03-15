import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Lam
 * @ClassName P56MergeIntervals
 * @date 2020/1/12
 */
public class P56MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
            int left = intervals[0][0];
            int right = intervals[0][1];
            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > right) {
                    intervals[count][0] = left;
                    intervals[count++][1] = right;
                    left = intervals[i][0];
                    right = intervals[i][1];
                } else if (intervals[i][1] > right) {
                    right = intervals[i][1];
                }
            }
            intervals[count][0] = left;
            intervals[count++][1] = right;
            int[][] result = new int[count][2];
            for (int i = 0; i < count; i++) {
                result[i] = intervals[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] datas = new int[][]{
                {2, 6},
                {1, 3},
                {15, 18},
                {8, 10},
        };

        int[][] merge = new P56MergeIntervals().new Solution().merge(datas);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
