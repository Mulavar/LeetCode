import bean.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @author Lam
 * @ClassName P25ReverseNodesInKGroup
 * @date 2020/3/15
 */
public class P25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        int count;
        ListNode start = head;
        ListNode end = start;
        ListNode last = new ListNode(0);
        last.next = start;
        boolean first = true;
        while (end != null) {
            count = k;
            while (end != null & count > 0) {
                end = end.next;
                count--;
            }

            if (count > 0) {
                break;
            }

            last.next = reverse(start, end);
            if (first) {
                newHead = last.next;
                first = false;
            }

            last = start;
            start = end;
        }
        return newHead;
    }

    //[start, end) 1->2->3->4 start:1 end:4
    // 3->2->1->4
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode cur = start.next;
        while (cur != end) {
            ListNode tmpNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmpNext;
        }
        start.next = end;
        return pre;
    }

}
