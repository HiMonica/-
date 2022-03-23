package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

