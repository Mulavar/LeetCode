import bean.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * @author Lam
 * @ClassName P143ReorderList
 * @date 2020/2/21
 */
public class P143ReorderList {
    class Solution {
        /**
         * 1. 将链表切为两半
         * 2. 后半部分逆序
         * 3. 拼接
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }

            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (fast != null&&fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;

            }

            ListNode right = slow.next;
            slow.next = null;
            // 2. 后半部分逆序
            ListNode cur = right;
            ListNode pre = null;
            ListNode post = null;
            while (cur != null) {
                post = cur.next;
                cur.next = pre;
                pre = cur;
                cur = post;
            }

            ListNode h1 = head;
            ListNode h2 = pre;
            while (h1 != null && h2 != null) {
                ListNode tmp1 = h1.next;
                ListNode tmp2 = h2.next;
                h1.next = h2;
                h2.next = tmp1;
                h1 = tmp1;
                h2 = tmp2;
            }

        }

    }

    public static void main(String[] args) {

    }
}
