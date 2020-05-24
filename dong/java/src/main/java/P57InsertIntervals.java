import java.util.Arrays;

/**
 * @author Lam
 * @date 2020/1/12
 */
public class P57InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] allIntervals = new int[intervals.length + 1][2];
        boolean inserted = false;
        int idx = 0;

        if (intervals.length == 0) {
            allIntervals[0] = newInterval;
        }
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0] && !inserted) {
                allIntervals[idx++] = newInterval;
                i--;
                inserted = true;
            } else {
                allIntervals[idx++] = intervals[i];
            }
        }
        if (!inserted) {
            allIntervals[idx] = newInterval;
        }

        return merge(allIntervals);
    }

    public int[][] merge(int[][] allIntervals) {
        int left = allIntervals[0][0];
        int right = allIntervals[0][1];
        int count = 0;
        for (int i = 1; i < allIntervals.length; i++) {
            if (allIntervals[i][0] > right) {
                allIntervals[count][0] = left;
                allIntervals[count++][1] = right;
                left = allIntervals[i][0];
                right = allIntervals[i][1];
            } else if (allIntervals[i][1] > right) {
                right = allIntervals[i][1];
            }
        }
        allIntervals[count][0] = left;
        allIntervals[count++][1] = right;
        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i] = allIntervals[i];
        }
        return result;
    }

}
