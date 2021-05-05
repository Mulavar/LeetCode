import org.junit.Assert;
import org.junit.Test;

public class TestP601Range700 {

    @Test
    public void testP689MaximumSum3NonOverlappingSubarrays() {
        P689MaximumSum3NonOverlappingSubarrays p689MaximumSum3NonOverlappingSubarrays = new P689MaximumSum3NonOverlappingSubarrays();
        Assert.assertArrayEquals(new int[]{0, 3, 5}, p689MaximumSum3NonOverlappingSubarrays.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2));
        Assert.assertArrayEquals(new int[]{4, 5, 7}, p689MaximumSum3NonOverlappingSubarrays.maxSumOfThreeSubarrays(new int[]{4, 5, 10, 6, 11, 17, 4, 11, 1, 3}, 1));
    }

    @Test
    public void testP698PartitionToKEqualSumSubsets() {
        P698PartitionToKEqualSumSubsets p698PartitionToKEqualSumSubsets = new P698PartitionToKEqualSumSubsets();
        Assert.assertTrue(p698PartitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        Assert.assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{4, 2, 3, 5, 2, 1}, 4));
        Assert.assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,3,3}, 8));

        Assert.assertTrue(p698PartitionToKEqualSumSubsets.canPartitionKSubsets1(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        Assert.assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets1(new int[]{4, 2, 3, 5, 2, 1}, 4));
        Assert.assertFalse(p698PartitionToKEqualSumSubsets.canPartitionKSubsets1(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,3,3}, 8));
    }
}
