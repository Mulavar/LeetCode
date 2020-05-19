import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * @author Lam
 * @ClassName P56MergeIntervals
 * @date 2020/1/12
 */
public class P56MergeIntervals {
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
                //不需要合并
                intervals[count][0] = left;
                intervals[count++][1] = right;
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][1] > right) {
                //需要合并
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
