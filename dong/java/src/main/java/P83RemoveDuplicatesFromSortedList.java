import bean.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @author Lam
 * @ClassName P83RemoveDuplicatesFromSortedList
 * @date 2020/3/15
 */
public class P83RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        ListNode end = head.next;
        int curVal = start.val;
        while (end != null) {
            if (end.val == curVal) {
                end = end.next;
                continue;
            }
            start.next = end;
            start = end;
            curVal = start.val;
        }
        start.next = null;
        return head;
    }
}
