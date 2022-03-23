package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 删除排序链表中的重复元素 II
 */
public class RemoveRepLinked {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node = new ListNode(0,head);
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null){
            if (pre.next.val == pre.next.next.val){
                int x = pre.next.val;
                while (pre.next != null && pre.next.val == x){
                    pre.next = pre.next.next;
                }
            }else {
                pre = pre.next;
            }
        }
        return node.next;
    }
}
