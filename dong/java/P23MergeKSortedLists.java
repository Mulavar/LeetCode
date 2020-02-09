import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Lam
 * @ClassName P23MergeKSortedLists
 * @date 2020/2/8
 */
public class P23MergeKSortedLists {
    /**
     * 使用内置的优先级队列
     */
    class Solution {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComp());
            for (ListNode listNode : lists) {
                while (listNode != null) {
                    queue.add(listNode);
                    listNode = listNode.next;
                }
            }

            ListNode head = queue.poll();
            ListNode node = head;
            while (!queue.isEmpty()) {
                node.next = queue.poll();
                node = node.next;
            }
            if (node != null) {
                node.next = null;
            }

            return head;
        }

        class ListNodeComp implements Comparator<ListNode> {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }
}
