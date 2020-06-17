package jzoffer;

import bean.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author Lam
 * @ClassName P52
 * @date 2020/6/17
 */
public class P52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 0;
        int n = 0;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            m++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            n++;
            nodeB = nodeB.next;
        }

        if (m < n) {
            nodeA = headA;
            headA = headB;
            headB = nodeA;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int k = m - n;
        while (k > 0) {
            headA = headA.next;
            k--;
        }

        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
