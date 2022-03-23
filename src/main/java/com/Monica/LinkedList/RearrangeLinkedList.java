package com.Monica.LinkedList;

import com.Monica.utils.ListNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表
 */
public class RearrangeLinkedList {

    /**
     * 思路：我的想法是将一个链表变成两个链表，从中间隔开，然后将后面的链表翻转，然后插入
     * 方法一：寻找链表中点 + 链表逆序 + 合并链表
     */
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        //找到中点
        ListNode mid = findMid(head);
        //链表1
        ListNode list1 = head;
        //断开，链表2
        ListNode list2 = mid.next;
        mid.next = null;
        //翻转链表2
        list2 = reverseList(list2);
        //合并两链表
        mergeList(list1,list2);
    }

    /**
     * 寻找中点：快慢指针
     */
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表逆序
     */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 合并链表，双指针
     */
    public void mergeList(ListNode list1,ListNode list2){
        ListNode pre1;
        ListNode pre2;
        while (list1 != null && list2 != null){
            pre1 = list1.next;
            pre2 = list2.next;

            list1.next = list2;
            list1 = pre1;

            list2.next = list1;
            list2 = pre2;
        }
    }

    /**
     * 方法二：存储在线性表中，因为线性表有下标
     */
    public void reorderList1(ListNode head){
        if (head == null){
            return;
        }
        List<ListNode> store = new ArrayList<>();
        ListNode pre = head;
        while (pre != null){
            store.add(pre);
            pre = pre.next;
        }
        int r = store.size() - 1;
        int l = 0;
        while (l < r){
            store.get(l).next = store.get(r);
            l++;
            if (l == r){
                return;
            }
            store.get(r).next = store.get(l);
            r--;
        }
        store.get(l).next = null;
    }

    public static void main(String[] args) {
        RearrangeLinkedList list = new RearrangeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        list.reorderList1(node1);
        System.out.println(JSON.toJSONString(node1.val));
        System.out.println(JSON.toJSONString(node1.next.val));
        System.out.println(JSON.toJSONString(node1.next.next.val));
        System.out.println(JSON.toJSONString(node1.next.next.next.val));
    }

}
