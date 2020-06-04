import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @date 2020/5/8
 */
public class TestP301RangeP400 {
    @Test
    public void testP312BurstBalloons() {
        int[] nums = new int[]{5};
        Assert.assertEquals(5, new P312BurstBalloons().maxCoins(nums));

        nums = new int[]{3, 1, 5, 8};
        Assert.assertEquals(167, new P312BurstBalloons().maxCoins(nums));
    }

    @Test
    public void testP325CountSmallerNumbersAfterSelf() {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new P325CountSmallerNumbersAfterSelf().countSmaller(nums));
        System.out.println(new P325CountSmallerNumbersAfterSelf().countSmaller1(nums));
    }

    @Test
    public void testP377CombinationSumIV() {
        new P377CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4);
    }
}
