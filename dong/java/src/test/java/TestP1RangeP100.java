import bean.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lam
 * @ClassName TestP1RangeP100
 * @date 2020/3/15
 */
public class TestP1RangeP100 {
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
    public void testP24SwapNodesInPairs() {
        System.out.println(new P24SwapNodesInPairs().swapPairs(head));
    }

    @Test
    public void testP25ReverseNodesInKGroup() {
        System.out.println(new P25ReverseNodesInKGroup().reverseKGroup(head, 2));
        prepare();
        System.out.println(new P25ReverseNodesInKGroup().reverseKGroup(head, 3));
    }

    @Test
    public void testP54SpiralMatrix() {
        System.out.println(new P54SpiralMatrix().spiralOrder(matrix2));
        prepare();
        ArrayList<Integer> result = new ArrayList<>();
        new P54SpiralMatrix().recursiveSpiral(result, matrix2, 0, 0, 4, 4);
        System.out.println(result);
    }

    @Test
    public void testP59SpiralMatrixII() {
        System.out.println(Arrays.deepToString(new P59SpiralMatrixII().generateMatrix(5)));
    }

    @Test
    public void testP82RemoveDuplicatesFromSortedListII() {
        System.out.println(new P82RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    @Test
    public void testP61RotateList() {
        System.out.println(new P61RotateList().rotateRight(head, 10));
    }

    @Test
    public void testP77Combinations() {
        System.out.println(new P77Combinations().combine(5, 3));
    }

    @Test
    public void testP83RemoveDuplicatesFromSortedList() {
        System.out.println(new P83RemoveDuplicatesFromSortedList().deleteDuplicates(head));
    }

    @Test
    public void testP86PartitionList() {
        System.out.println(new P86PartitionList().partition(head1, 3));
    }

    @Test
    public void testP92ReverseLinkedListII() {
        System.out.println(new P92ReverseLinkedListII().reverseBetween(head, 2, 4));
    }

    @Test
    public void testP93RestoreIpAddresses() {
        System.out.println(new P93RestoreIpAddresses().restoreIpAddresses("010010"));
    }

}