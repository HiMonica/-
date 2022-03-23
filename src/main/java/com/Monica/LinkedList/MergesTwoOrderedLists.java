package com.Monica.LinkedList;

import com.Monica.utils.ListNode;

/**
 * 合并两有序链表
 */
public class MergesTwoOrderedLists {

    /**
     * 双指针
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        //指针
        ListNode pre = newNode;
        while (list1 != null || list2 != null){
            if (list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return newNode.next;
    }

}
