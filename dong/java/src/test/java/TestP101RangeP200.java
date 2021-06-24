import bean.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @ClassName TestP101RangeP200
 * @date 2020/5/4
 */
public class TestP101RangeP200 {
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
    public void testP115DistinctSubsequences() {
        String s = "abb";
        String t = "ab";
        Assert.assertEquals(2, new P115DistinctSubsequences().numDistinct(s, t));

        s = "rabbbit";
        t = "rabbit";
        Assert.assertEquals(3, new P115DistinctSubsequences().numDistinct(s, t));
    }

    @Test
    public void testP122BestTimeToBuySellStockII() {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        Assert.assertEquals(7, new P122BestTimeToBuySellStockII().maxProfit(nums));
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(4, new P122BestTimeToBuySellStockII().maxProfit(nums1));
    }

    @Test
    public void testP123BestTimeToBuySellStockIII() {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(4, new P123BestTimeToBuySellStockIII().maxProfit(prices));

        prices = new int[]{2, 1, 2, 1, 0, 0, 1};
        Assert.assertEquals(2, new P123BestTimeToBuySellStockIII().maxProfit1(prices));
        Assert.assertEquals(2, new P123BestTimeToBuySellStockIII().maxProfit2(prices));
    }

    @Test
    public void testP128LongestConsecutiveSequence() {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, new P128LongestConsecutiveSequence().longestConsecutive2(nums));
    }

    @Test
    public void testP132PalindromePartitioningII() {
        Assert.assertEquals(1, new P132PalindromePartitioningII().minCut("aab"));
    }

    @Test
    public void testP135Candy() {
        int[] grades = new int[]{29, 51, 87, 87, 72, 12};
        Assert.assertEquals(12, new P135Candy().candy(grades));
        Assert.assertEquals(12, new P135Candy().candy1(grades));
        Assert.assertEquals(4, new P135Candy().candy2(new int[]{1, 2, 2}));
    }

    @Test
    public void testP140WordBreakII() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new P140WordBreakII().wordBreak(s, wordDict));
    }

    @Test
    public void testP148SortList() {
        System.out.println(new P148SortList().sortList(head));
    }

    @Test
    public void testP164MaximumGap() {
        int[] nums = new int[]{3, 6, 9, 1};
        Assert.assertEquals(3, new P164MaximumGap().maximumGap1(nums));
        nums = new int[]{1, 10000000};
        Assert.assertEquals(10000000 - 1, new P164MaximumGap().maximumGap1(nums));

        nums = new int[]{100, 3, 2, 1};
        Assert.assertEquals(97, new P164MaximumGap().maximumGap1(nums));
    }

    @Test
    public void testP188BestTimeToBuyAndSellStockIV() {
        System.out.println(new P188BestTimeToBuyAndSellStockIV().maxProfit(4, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
}
