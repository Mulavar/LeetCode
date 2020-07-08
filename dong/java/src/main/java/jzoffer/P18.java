package jzoffer;

import bean.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * @author Lam
 * @date 2020/7/5
 */
public class P18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode shim = new ListNode(-1);
        shim.next = head;

        ListNode node = shim;
        while (node.next!=null&&node.next.val!=val) {
            node = node.next;
        }

        if (node.next!=null) {
            node.next = node.next.next;
        }
        return shim.next;
    }
}
