package com.Monica.List;

import com.Monica.utils.ListNode;

/**
 * 反转链表
 */
public class ReverseList {
    class Solution {
        /**
         * 方法一：迭代法
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        /**
         * 方法二：递归法
         * @param head
         * @return
         */
        public ListNode reverseList2(ListNode head){
            if (head == null || head.next == null){
                return head;
            }
            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    private void dontStop(){
        while (true){

        }
    }

    private void stackLeakByThread(){
        while (true){
            new Thread(()->dontStop()).start();
        }
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        reverseList.stackLeakByThread();
    }
}

