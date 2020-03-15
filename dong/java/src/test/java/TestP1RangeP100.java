import bean.ListNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Lam
 * @ClassName TestP1RangeP100
 * @date 2020/3/15
 */
public class TestP1RangeP100 {
    private ListNode head;

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
    public void testP82RemoveDuplicatesFromSortedListII() {
        System.out.println(new P82RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    @Test
    public void testP61RotateList() {
        System.out.println(new P61RotateList().rotateRight(head, 10));
    }

    @Test
    public void testP83RemoveDuplicatesFromSortedList() {
        System.out.println(new P83RemoveDuplicatesFromSortedList().deleteDuplicates(head));
    }

}
