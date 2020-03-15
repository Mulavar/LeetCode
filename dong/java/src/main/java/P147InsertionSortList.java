import bean.ListNode;

/**
 * @author Lam
 * @ClassName P147InsertionSortList
 * @date 2020/2/21
 */
public class P147InsertionSortList {
    class Solution {
        /**
         * 使用递归
         */
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode sortedHead = insertionSortList(head.next);
            ListNode pre = null;
            ListNode node = sortedHead;
            while (node != null && node.val < head.val) {
                pre = node;
                node = node.next;
            }
            if (pre == null) {
                head.next = sortedHead;
                return head;
            } else {
                head.next = pre.next;
                pre.next = head;
                return sortedHead;
            }
        }
    }

    class Solution1 {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode node = head.next;
            ListNode pre = head;
            ListNode next = null;
            while (node != null) {
                if (pre.val <= node.val) {
                    pre = node;
                    node = node.next;
                    continue;
                }
                ListNode tmpPre = null;
                ListNode tmpNode = head;
                while (tmpNode.val < node.val) {
                    tmpPre = tmpNode;
                    tmpNode = tmpNode.next;
                }

                next = node.next;
                pre.next = next;
                if (tmpPre == null) {
                    node.next = head;
                    head = node;
                } else {
                    tmpPre.next = node;
                    node.next = tmpNode;
                }
                node = next;
            }
            return head;
        }
    }
}
