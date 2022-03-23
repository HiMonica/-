package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 */
public class RemoveLastN {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(0,head);
        ListNode pre = head;
        ListNode cur = newNode;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        while (pre == null){
            pre = pre.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return newNode.next;
    }
}
