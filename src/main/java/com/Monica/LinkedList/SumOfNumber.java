package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 两数之和
 */
public class SumOfNumber {

    /**
     * 方法：模拟，就是看进位，有进位加上进位就好了
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        //进位
        int count = 0;
        while (l1 != null || l2 != null){
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + count;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            count = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (count != 0){
            tail.next = new ListNode(count);
        }
        return head;
    }
}
