import bean.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Lam
 * @ClassName P24SwapNodesInPairs
 * @date 2020/3/15
 */
public class P24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head == null ? null : head.next;
        while (end != null) {
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = start;
            start.next = next;
            pre.next = end;
            pre = start;
            end = next == null ? null : next.next;
        }

        return dummy.next;
    }
}
