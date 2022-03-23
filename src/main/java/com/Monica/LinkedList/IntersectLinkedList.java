package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 */
public class IntersectLinkedList {

    /**
     * 方法一：hash表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeMethod1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> store = new HashSet<>();
        //遍历第一个链表存入store
        ListNode pA = headA;
        while (pA != null){
            store.add(pA);
            pA = pA.next;
        }
        //遍历第二个链表看是否存相同节点
        ListNode pB = headB;
        while (pB != null){
            if (store.contains(pB)){
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }


    /**
     * 方法二：双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeMethod2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
