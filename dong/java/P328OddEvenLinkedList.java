import bean.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * @author Lam
 * @ClassName P328OddEvenLinkedList
 * @date 2020/2/21
 */
public class P328OddEvenLinkedList {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode head1 = head.next;

            ListNode cur = head;
            ListNode next;
            while (cur.next != null) {
                next = cur.next;
                cur.next = next.next;
                cur = next;
            }

            cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = head1;
            return head;
        }
    }
}
