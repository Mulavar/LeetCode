import bean.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lam
 * @date 2020/5/24
 */
public class TestP201RangeP300 {
    private ListNode head;
    private ListNode head1;
    private int[][] matrix2;

    @Before
    public void prepare() {
        head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        matrix2 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        head1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = new ListNode(2);
    }

    @Test
    public void testP204CountPrimes() {
        Assert.assertEquals(4, new P204CountPrimes().countPrimes(10));
        Assert.assertEquals(1, new P204CountPrimes().countPrimes(3));
        Assert.assertEquals(2, new P204CountPrimes().countPrimes(4));
        Assert.assertEquals(3, new P204CountPrimes().countPrimes(7));
    }

    @Test
    public void testP219ContainsDuplicateII() {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        Assert.assertEquals(false, new P219ContainsDuplicateII().containsNearbyDuplicate(nums, 2));
    }

    @Test
    public void testP240Search2DMatrixII() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {
                        18, 21, 23, 26, 30
                },
        };
        Assert.assertEquals(new P240Search2DMatrixII().searchMatrix1(matrix, 5), new P240Search2DMatrixII().searchMatrix(matrix, 5));

        matrix = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30},
        };
        Assert.assertEquals(new P240Search2DMatrixII().searchMatrix1(matrix, 20), new P240Search2DMatrixII().searchMatrix(matrix, 20));

        matrix = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30},
        };
        Assert.assertEquals(new P240Search2DMatrixII().searchMatrix1(matrix, 5), new P240Search2DMatrixII().searchMatrix(matrix, 5));


        matrix = new int[][]{{-1, 3}};
        Assert.assertEquals(new P240Search2DMatrixII().searchMatrix1(matrix, 3), new P240Search2DMatrixII().searchMatrix(matrix, 3));

        matrix = new int[][]{{5}, {6}};
        Assert.assertEquals(new P240Search2DMatrixII().searchMatrix1(matrix, 6), new P240Search2DMatrixII().searchMatrix(matrix, 6));
    }


    @Test
    public void testP239SlidingWindowMaximum() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Assert.assertEquals(Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow(nums, 3)), Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow1(nums, 3)));
        Assert.assertEquals(Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow(nums, 3)), Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow2(nums, 3)));
    }

    @Test
    public void testP243ShortestWordDistance() {
        String[] words = new String[]{"a", "b", "c", "d", "d"};
        Assert.assertEquals(3, new P243ShortestWordDistance().shortestDistance(words, "a", "d"));
    }

    @Test
    public void testP245ShortestWordDistanceIII() {
        String[] words = new String[]{"a", "b", "c", "d", "d"};
        System.out.println(new P245ShortestWordDistanceIII().shortestDistance(words, "d", "d"));
    }

    @Test
    public void testP253MeetingRoomsII() {
        int[][] meetings = new int[][]{
                {7, 10},
                {2, 4},
        };

        Assert.assertEquals(1, new P253MeetingRoomsII().minMeetingRooms(meetings));

        int[][] meetings1 = new int[][]{
                {2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        Assert.assertEquals(2, new P253MeetingRoomsII().minMeetingRooms(meetings1));
    }

    @Test
    public void testP265PaintHouseII() {
        int[][] costs = new int[][]{{1, 5, 3}, {2, 9, 4}};
        Assert.assertEquals(5, new P265PaintHouseII().minCostII(costs));

        costs = new int[][]{
                {4, 16}, {15, 5}, {18, 17}, {10, 12}, {14, 10}, {3, 10}, {2, 11}, {18, 14}, {9, 1}, {14, 13},
        };
        Assert.assertEquals(101, new P265PaintHouseII().minCostII(costs));
    }

    @Test
    public void testP296BestMeetingPoint() {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        };
        Assert.assertEquals(6, new P296BestMeetingPoint().minTotalDistance(grid));
    }
}
