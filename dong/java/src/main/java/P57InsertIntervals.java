/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
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
        //先插入适合的位置再合并
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

    // 插入与合并同时进行
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int l = -1;
        int r = -1;
        int len = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            //r是最多合并的位置
            if (intervals[i][0] <= newInterval[1]) {
                r = i;
            }
            //l是应该插入的位置
            if (intervals[i][1] < newInterval[0]) {
                l = i + 1;
            }
        }
        l = l == -1 ? 0 : l;

        int newLen = len - (r - l);
        int[][] result = new int[newLen][2];
        for (int i = 0; i < newLen; i++) {
            if (i < l) {
                result[i] = intervals[i];
            } else if (i == l) {
                if (i < len && r != -1) {
                    result[i] = new int[]{Math.min(intervals[l][0], newInterval[0]), Math.max(intervals[r][1], newInterval[1])};
                    continue;
                } else {
                    result[i] = newInterval;
                }
            } else {
                result[i] = intervals[len - newLen + i];
            }
        }

        return result;
    }
}
