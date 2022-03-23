package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class LastKParam {

    /**
     * 方法一：双指针，第一个指针先跑，跑到k的地方，第二个指针再和第一个指针一起跑，他们之间的间隔就是k
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            if (first.next != null){
                first = first.next;
            }else {
                return head;
            }
        }
        while (first != null){
            second = second.next;
            first = first.next;
        }
        return second;
    }

    /**
     * 方法二：算长度
     */
    public ListNode getKthFromEndMethodTwo(ListNode head, int k){
        int length = 0;
        ListNode node = null;
        for (node = head;node != null;node = node.next){
            ++length;
        }
        for (node = head;length > k;length--){
            node = node.next;
        }
        return node;
    }
}
