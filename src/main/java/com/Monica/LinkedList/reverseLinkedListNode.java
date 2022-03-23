package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

import java.util.List;

/**
 * 两两交换链表中的节点
 */
public class reverseLinkedListNode {

    /**
     * 思路：双指针，一个指针指向后面一个节点，一个指针指向前面一个节点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode temp = newNode;
        while (temp.next != null && temp.next.next != null){
            ListNode pre = temp.next;
            ListNode curr = temp.next.next;
            temp.next = curr;
            pre.next = curr.next;
            curr.next = pre;
            temp = pre;
        }
        return newNode.next;
    }
}
