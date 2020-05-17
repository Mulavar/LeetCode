import bean.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testP135Candy() {
        int[] grades = new int[]{29, 51, 87, 87, 72, 12};
        Assert.assertEquals(12 ,new P135Candy().candy(grades));
        Assert.assertEquals(12 ,new P135Candy().candy1(grades));
        Assert.assertEquals(4 ,new P135Candy().candy2(new int[]{1, 2, 2}));
    }

    @Test
    public void testP148SortList() {
        System.out.println(new P148SortList().sortList(head));
    }
    @Test
    public void testP188BestTimeToBuyAndSellStockIV() {
        System.out.println(new P188BestTimeToBuyAndSellStockIV().maxProfit(4, new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
