import java.util.Arrays;
import java.util.Comparator;

/**
 *
 给定一个会议时间安排的数组，
 每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
 请你判断一个人是否能够参加这里面的全部会议。
 * @author Lam
 * @date 2020/7/17
 */
public class P252MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new MeetingComparator());

        int last = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0]<last) {
                return false;
            }
            last = intervals[i][1];
        }

        return true;
    }

    static class MeetingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
