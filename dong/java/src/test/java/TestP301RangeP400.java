import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void testP305NumberIslandsII() {
        int[][] positions = new int[][]{
                {0, 0}, {0, 1}, {1, 2}, {2, 1},
        };
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Assert.assertEquals(expected, new P305NumberIslandsII().numIslands2(3, 3, positions));
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
    public void testP308RangeSumQuery2DMutable() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        P308RangeSumQuery2DMutable.NumMatrix tree = new P308RangeSumQuery2DMutable().new NumMatrix(matrix);
        Assert.assertEquals(12, tree.sumRegion(0, 0, 1, 1));
        tree.update(0, 0, 2);

        Assert.assertEquals(13, tree.sumRegion(0, 0, 1, 1));

        matrix = new int[][]{
                {2, 4},
                {-3, 5}
        };
        P308RangeSumQuery2DMutable.NumMatrix tree1 = new P308RangeSumQuery2DMutable().new NumMatrix(matrix);
        tree1.update(0, 1, 3);
        tree1.update(1, 1, -3);
        tree1.update(0, 1, 1);
        Assert.assertEquals(-3, tree1.sumRegion(0, 0, 1, 1));
    }

    @Test
    public void testP309BestTimeToBuyAndSellStockWithCooldown() {
        int[] prices = {2, 1, 4, 5, 2, 9, 7};
        Assert.assertEquals(10, new P309BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));

        prices = new int[]{1, 2, 4};
        Assert.assertEquals(3, new P309BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
        Assert.assertEquals(3, new P309BestTimeToBuyAndSellStockWithCooldown().maxProfit1(prices));
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
    public void testP317ShortestDistanceFromAllBuildings() {
        int[][] grid = new int[][]{
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        Assert.assertEquals(7, new P317ShortestDistanceFromAllBuildings().shortestDistance(grid));
    }

    @Test
    public void testP318MaximumProductWordLengths() {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        Assert.assertEquals(16, new P318MaximumProductWordLengths().maxProduct(words));
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
        Assert.assertEquals(4, new P329LongestIncreasingPathInMatrix().longestIncreasingPath1(matrix));
    }

    @Test
    public void testP335SelfCrossing() {
        int[] x = new int[]{2, 1, 1, 2};
        Assert.assertTrue(new P335SelfCrossing().isSelfCrossing(x));
        x = new int[]{1, 1, 1, 1};
        Assert.assertTrue(new P335SelfCrossing().isSelfCrossing(x));
        x = new int[]{1, 2, 3, 4};
        Assert.assertFalse(new P335SelfCrossing().isSelfCrossing(x));
        x = new int[]{3, 3, 4, 2, 2};
        Assert.assertFalse(new P335SelfCrossing().isSelfCrossing(x));
    }

    @Test
    public void testP336PalindromePairs() {
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new P336PalindromePairs().palindromePairs(words));

        words = new String[]{"a", ""};

        System.out.println(new P336PalindromePairs().palindromePairs(words));
    }

    @Test
    public void testP354RussianDollEnvelopes() {
        int[][] envelopes = new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        Assert.assertEquals(3, new P354RussianDollEnvelopes().maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}
        };
        Assert.assertEquals(4, new P354RussianDollEnvelopes().maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}
        };
        Assert.assertEquals(3, new P354RussianDollEnvelopes().maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {30, 50}, {12, 2}, {3, 4}, {12, 15}
        };
        Assert.assertEquals(3, new P354RussianDollEnvelopes().maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}
        };
        Assert.assertEquals(5, new P354RussianDollEnvelopes().maxEnvelopes(envelopes));

    }

    @Test
    public void testP377CombinationSumIV() {
        new P377CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4);
    }

    @Test
    public void testP378KthSmallestElementInASortedMatrix() {
        int[][] matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Assert.assertEquals(13, new P378KthSmallestElementInASortedMatrix().kthSmallest(matrix, 8));

        matrix = new int[][] {
                {1, 2},
                {1, 3}
        };
        Assert.assertEquals(3, new P378KthSmallestElementInASortedMatrix().kthSmallest(matrix, 4));
    }
}
