import bean.ListNode;

/**
 * @author Lam
 * @ClassName P142LinkedListCycleII
 * @date 2020/2/21
 */
public class P142LinkedListCycleII {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next.next;
            while (fast != null && slow != fast) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                } else {
                    break;
                }
            }
            if (fast == null) {
                return null;
            }

            ListNode newSt = head;
            while (newSt != slow) {
                newSt = newSt.next;
                slow = slow.next;
            }

            return slow;
        }
    }
}
