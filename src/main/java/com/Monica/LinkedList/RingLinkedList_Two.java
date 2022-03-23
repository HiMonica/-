package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 */
public class RingLinkedList_Two {

    /**
     * 快慢指针
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            //相遇，再创建一个指针从开始位置移动
            if (slow == fast){
                ListNode pre = head;
                while (pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }

    /**
     * 哈希表，不存在存入，存在退出循环返回
     */
    public ListNode detectCycleMethod(ListNode head) {
        Set<ListNode> store = new HashSet<>();
        ListNode curr = head;
        while (!store.contains(curr)){
            if (curr == null){
                return null;
            }
            store.add(curr);
            curr = curr.next;
        }
        return curr;
    }
}
