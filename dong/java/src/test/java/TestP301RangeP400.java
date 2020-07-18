import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lam
 * @date 2020/5/8
 */
public class TestP301RangeP400 {
    @Test
    public void testP301RemoveInvalidParentheses() {
        String s = "()())()";
        System.out.println(new P301RemoveInvalidParentheses().removeInvalidParentheses(s));
    }

    @Test
    public void testP310MinimumHeightTrees() {
        int[][] edges = new int[][]{
                {1, 0}, {1, 2}, {1, 3},
        };
        int n = 4;
        Assert.assertEquals(Arrays.asList(1), new P310MinimumHeightTrees().findMinHeightTrees(n, edges));
    }

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
