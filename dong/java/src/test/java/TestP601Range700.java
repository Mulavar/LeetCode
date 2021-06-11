import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestP601Range700 {

    @Test
    public void testP621TaskScheduler() {
        P621TaskScheduler p621TaskScheduler = new P621TaskScheduler();
        assertEquals(8, p621TaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    @Test
    public void testP689MaximumSum3NonOverlappingSubarrays() {
        P689MaximumSum3NonOverlappingSubarrays p689MaximumSum3NonOverlappingSubarrays =
                new P689MaximumSum3NonOverlappingSubarrays();
        assertArrayEquals(new int[]{0, 3, 5},
                p689MaximumSum3NonOverlappingSubarrays.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2));
        assertArrayEquals(new int[]{4, 5, 7}, p689MaximumSum3NonOverlappingSubarrays
                .maxSumOfThreeSubarrays(new int[]{4, 5, 10, 6, 11, 17, 4, 11, 1, 3}, 1));
    }

    @Test
    public void testP698PartitionToKEqualSumSubsets() {
        P698PartitionToKEqualSumSubsets p698PartitionToKEqualSumSubsets = new P698PartitionToKEqualSumSubsets();
        assertTrue(p698PartitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 2, 3, 5, 2, 1}, 4));
        assertFalse(p698PartitionToKEqualSumSubsets
                .canPartitionKSubsets(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3}, 8));

        assertTrue(p698PartitionToKEqualSumSubsets.canPartitionKSubsets1(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets1(new int[]{4, 2, 3, 5, 2, 1}, 4));
        assertFalse(p698PartitionToKEqualSumSubsets
                .canPartitionKSubsets1(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3}, 8));
    }
}