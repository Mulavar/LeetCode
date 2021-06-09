import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
/**
 * @author Lam
 * @date 2020/6/3
 */
public class TestP401RangeP500 {

    @Test
    public void testP402RemoveKDigits() {
        assertEquals("200", new P402RemoveKDigits().removeKdigits("10200", 1));
    }

    @Test
    public void testP406QueueReconstructionByHeight() {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2},};
        //TODO
        System.out.println(Arrays.deepToString(new P406QueueReconstructionByHeight().reconstructQueue(people)));
    }

    @Test
    public void testP435NonOverlappingIntervals() {
        int[][] intervals = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        assertEquals(2, new P435NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }

    @Test
    public void testP452Qiqiu() {
        int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        assertEquals(2, new P452MinimumNumberArrowsToBurstBalloons().findMinArrowShots(points));

    }

    @Test
    public void testP440KthSmallestInLexicographicalOrder() {
        assertEquals(10, new P440KthSmallestInLexicographicalOrder().findKthNumber(13, 2));
        assertEquals(20, new P440KthSmallestInLexicographicalOrder().findKthNumber(30, 13));
        assertEquals(17, new P440KthSmallestInLexicographicalOrder().findKthNumber(100, 10));
    }
}