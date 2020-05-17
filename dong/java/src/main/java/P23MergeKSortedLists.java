import bean.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * @author Lam
 * @ClassName P23MergeKSortedLists
 * @date 2020/2/8
 */
public class P23MergeKSortedLists {
    /**
     * 使用内置的优先级队列
     */
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

    /**
     * 归并排序
     *
     * @param lists 需要排序的链表们
     * @return 排序后的
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        int n = lists.length;
        if (n < 1) {
            return null;
        }
        while (n != 1) {
            int i = 0;
            int cnt = 0;
            while (i < n && i + 1 < n) {
                lists[cnt++] = merge(lists[i], lists[i + 1]);
                System.out.println("**" + lists[cnt - 1]);
                i += 2;
            }
            if (i == n - 1) {
                lists[cnt++] = lists[i];
            }
            n = cnt;
        }
        return lists[0];
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode nHead = new ListNode(-1);
        ListNode node = nHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        } else {
            node.next = node2;
        }
        return nHead.next;
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
