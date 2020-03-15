import bean.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * @author Lam
 * @ClassName P61RotateList
 * @date 2020/3/15
 */
public class P61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }

        int idx = len;
        node = dummy;

        while (idx > k) {
            node = node.next;
            idx--;
        }

        start = node.next;
        dummy.next = start;
        node.next = null;
        while (start.next != null) {
            start = start.next;
        }
        start.next = head;

        return dummy.next;
    }

}
