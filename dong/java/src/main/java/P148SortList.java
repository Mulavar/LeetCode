import bean.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * Tips：归并排序
 *
 * @author Lam
 * @date 2020/5/16
 */
public class P148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. 快慢指针找到mid
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        // 2. 递归
        ListNode newHead1 = sortList(head);
        ListNode newHead2 = sortList(mid);

        // 3. 合并
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (newHead1 != null && newHead2 != null) {
            if (newHead1.val < newHead2.val) {
                node.next = newHead1;
                newHead1 = newHead1.next;
            } else {
                node.next = newHead2;
                newHead2 = newHead2.next;
            }
            node = node.next;
        }

        if (newHead1 != null) {
            node.next = newHead1;
        }
        if (newHead2 != null) {
            node.next = newHead2;
        }

        return newHead.next;

    }
}
