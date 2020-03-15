import bean.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * @author Lam
 * @ClassName P82RemoveDuplicatesFromSortedListII
 * @date 2020/3/15
 */
public class P82RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = head.next;
        int curVal = start.val;
        while (end!=null) {
            if (end.val==curVal) {
                end = end.next;
                continue;
            }

            if (start.next!=end) {
                //start有重复元素，跳过start
                pre.next = end;
            } else {
                //start无重复元素
                pre.next = start;
                pre = start;
            }
            start = end;
            end = end.next;
            curVal = start.val;
        }

        if (start.next!=null) {
            pre.next = null;
        }

        return dummy.next;
    }
}
