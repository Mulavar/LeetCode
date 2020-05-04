import bean.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //找到第m-1个节点
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode newHead = tmpHead;
        int nm = m;
        while (newHead != null && nm > 1) {
            newHead = newHead.next;
            nm--;
        }

        if (newHead == null) {
            return head;
        }

        newHead.next = reverse(newHead.next, n - m);

        return tmpHead.next;
    }


    /**
     * 翻转从head开始的m+1个节点
     * @param head 需要翻转的部分的头节点
     * @param m 需要翻转的节点个数-1
     * @return 翻转后的头节点
     */
    private ListNode reverse(ListNode head, int m) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next;
        while (m > 0 && next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            m--;
        }
        head.next = next;
        return pre;
    }
}
