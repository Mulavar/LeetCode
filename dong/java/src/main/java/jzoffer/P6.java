package jzoffer;

import bean.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author Lam
 * @date 2020/6/30
 */
public class P6 {
    private int idx = 0;

    /**
     * 1. 递归
     */
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        int[] result = new int[length];
        recursive(head, result);
        return result;
    }

    private void recursive(ListNode head, int[] result) {
        if (head == null) {
            return;
        }
        recursive(head.next, result);
        result[idx++] = head.val;
    }

    /**
     * 2. 循环，先反转链表
     */
    public int[] reversePrint1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        int length = 0;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            length++;
        }
        //now pre is new head;
        int[] result = new int[length];
        int idx = 0;
        while (pre != null) {
            result[idx++] = pre.val;
            pre = pre.next;
        }
        return result;
    }
}
