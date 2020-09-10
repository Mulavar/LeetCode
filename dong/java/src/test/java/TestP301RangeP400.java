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
    public void testP307RangeSumQueryMutable() {
        int[] nums = new int[]{1, 3, 5};
        P307RangeSumQueryMutable.NumArray array = new P307RangeSumQueryMutable().new NumArray(nums);
        Assert.assertEquals(9, array.sumRange(0, 2));
        array.update(1, 2);
        Assert.assertEquals(8, array.sumRange(0, 2));

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
    public void testP315CountSmallerNumbersAfterSelf() {
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(new P315CountSmallerNumbersAfterSelf().countSmaller(nums));
        System.out.println(new P315CountSmallerNumbersAfterSelf().countSmaller1(nums));
    }

    @Test
    public void testP316RemoveDuplicateLetters() {
        Assert.assertEquals("abc", new P316RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
        Assert.assertEquals("bca", new P316RemoveDuplicateLetters().removeDuplicateLetters("bcab"));
    }

    @Test
    public void testP321CreateMaximumNumber() {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        Assert.assertArrayEquals(new int[]{9, 8, 6, 5, 3}, new P321CreateMaximumNumber().maxNumber(nums1, nums2, 5));

        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        Assert.assertArrayEquals(new int[]{6, 7, 6, 0, 4}, new P321CreateMaximumNumber().maxNumber(nums1, nums2, 5));

        nums1 = new int[]{2,5,6,4,4,0};
        nums2 = new int[]{7,3,8,0,6,5,7,6,2};
        System.out.println(Arrays.toString(new P321CreateMaximumNumber().maxNumber(nums1, nums2, 15)));
    }
    @Test
    public void testP325MaximumSizeSubarraySumEqualsK() {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(new P325MaximumSizeSubarraySumEqualsK().maxSubArrayLen(nums, k));
    }

    @Test
    public void testP327CountRangeSum() {
        int[] nums = new int[]{-2, 5, -1};
        Assert.assertEquals(3, new P327CountRangeSum().countRangeSum(nums, -2, 2));

        nums = new int[]{-1, 1};
        Assert.assertEquals(1, new P327CountRangeSum().countRangeSum(nums, 0, 0));

        nums = new int[]{-2147483647, 0, -2147483647, 2147483647};
        Assert.assertEquals(3, new P327CountRangeSum().countRangeSum(nums, 0, 0));
    }

    @Test
    public void testP329LongestIncreasingPathInMatrix() {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        Assert.assertEquals(4, new P329LongestIncreasingPathInMatrix().longestIncreasingPath(matrix));
    }

    @Test
    public void testP377CombinationSumIV() {
        new P377CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4);
    }
}
