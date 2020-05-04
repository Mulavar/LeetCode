import bean.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P86PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode shim = new ListNode(-1);
        shim.next = head;
        ListNode newHead = shim;
        while (newHead.next != null && newHead.next.val < x) {
            newHead = newHead.next;
        }

        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                cur = cur.next;
                continue;
            }
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
            newHead = tmp;
        }

        return shim.next;
    }
}
