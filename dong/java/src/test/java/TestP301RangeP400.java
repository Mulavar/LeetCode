import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @date 2020/5/8
 */
public class TestP301RangeP400 {
    @Test
    public void testP325CountSmallerNumbersAfterSelf() {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new P315CountSmallerNumbersAfterSelf().countSmaller(nums));
        System.out.println(new P315CountSmallerNumbersAfterSelf().countSmaller1(nums));
    }

    @Test
    public void testP327CountRangeSum() {
        int[] nums = new int[]{-2, 5, -1};
        Assert.assertEquals(3, new P327CountRangeSum().countRangeSum(nums, -2, 2));

        nums = new int[]{-1, 1};
        Assert.assertEquals(1, new P327CountRangeSum().countRangeSum(nums, 0, 0));

        nums = new int[]{-2147483647,0,-2147483647,2147483647};
        Assert.assertEquals(3, new P327CountRangeSum().countRangeSum(nums, 0, 0));
    }

    @Test
    public void testP377CombinationSumIV() {
        new P377CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4);
    }
}
