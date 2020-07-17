import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * @author Lam
 * @date 2020/7/17
 */
public class P253MeetingRoomsII {
    /**
     * 优先级队列，每次找出最早结束的会议，查看是否需要更多会议室
     */
    public int minMeetingRooms(int[][] intervals) {
        // 只需要记录结束时间，不需要记录开始时间
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new MeetingEndComparator());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 可以使用lambda表达式优化
//        Arrays.sort(intervals, new MeetingStartComparator());
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);


        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (priorityQueue.isEmpty() || intervals[i][0] < priorityQueue.peek()) {
                result++;
            } else {
                priorityQueue.poll();
            }
            priorityQueue.offer(intervals[i][1]);
        }

        return result;
    }

    static class MeetingStartComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }
    }

}
