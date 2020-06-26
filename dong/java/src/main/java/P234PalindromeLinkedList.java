import bean.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * @author Lam
 * @date 2020/6/26
 */
public class P234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nHead = reverse(slow.next);
        while (nHead != null) {
            if (head.val != nHead.val) {
                return false;
            }
            nHead = nHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode pre = root;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        root.next = null;
        return pre;
    }
}
