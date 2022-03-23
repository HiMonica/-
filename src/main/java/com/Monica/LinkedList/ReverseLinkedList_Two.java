package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 反转链表 II
 */
public class ReverseLinkedList_Two {

    /**
     * 反转指定部分，把指定部分截取出来，然后反转
     * 问题：需要保存截取了的前半段和后半段，因为反转之后还需要连接，保存断开的那个节点就OK
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        //遍历指针
        ListNode curr = newNode;
        for (int i = 0; i < left - 1; i++) {
            curr = curr.next;
        }
        //前半段的最后一个节点
        ListNode first = curr;
        ListNode firstHalf =  curr.next;
        for (int i = 0; i < right - left + 1; i++) {
            curr = curr.next;
        }
        ListNode latterHalf = curr;
        //后半段的第一个节点
        ListNode second = curr.next;
        //截取
        latterHalf.next = null;
        first.next = null;
        reverse(firstHalf);
        first.next = latterHalf;
        firstHalf.next = second;
        return newNode.next;
    }

    /**
     * 反转链表
     */
    public void reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}
