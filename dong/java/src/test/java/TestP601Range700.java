import org.junit.Assert;
import org.junit.Test;

public class TestP601Range700 {

    @Test
    public void testP689MaximumSum3NonOverlappingSubarrays() {
        P689MaximumSum3NonOverlappingSubarrays p689MaximumSum3NonOverlappingSubarrays = new P689MaximumSum3NonOverlappingSubarrays();
        Assert.assertArrayEquals(new int[]{0, 3, 5}, p689MaximumSum3NonOverlappingSubarrays.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2));
        Assert.assertArrayEquals(new int[]{4, 5, 7}, p689MaximumSum3NonOverlappingSubarrays.maxSumOfThreeSubarrays(new int[]{4, 5, 10, 6, 11, 17, 4, 11, 1, 3}, 1));
    }
}
