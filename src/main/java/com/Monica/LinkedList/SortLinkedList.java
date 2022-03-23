package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 排序链表
 */
public class SortLinkedList {

    // TODO: 2022/2/26 超出时间了，看看有没有优化
    /**
     * 排序法里面的归并
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //快慢指针，去找中间的位置
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode newNode = new ListNode(0);
        ListNode pre = newNode;
        while (left != null && right != null){
            if (left.val < right.val){
                pre.next = right;
                left = left.next;
            }else {
                pre.next = left;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left != null ? left : right;
        return newNode.next;
    }
}
