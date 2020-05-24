import bean.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lam
 * @date 2020/5/24
 */
public class TestP201RangeP300 {
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
    public void testP239SlidingWindowMaximum() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Assert.assertEquals(Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow(nums, 3)), Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow1(nums, 3)));
        Assert.assertEquals(Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow(nums, 3)), Arrays.toString(new P239SlidingWindowMaximum().maxSlidingWindow2(nums, 3)));

    }
}
