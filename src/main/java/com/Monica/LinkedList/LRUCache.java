package com.Monica.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    /**
     * 双向链表
     */
    class DoubleLinkedList{
        int key;
        int value;
        DoubleLinkedList prev;
        DoubleLinkedList next;

        public DoubleLinkedList(){}

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Object, DoubleLinkedList> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkedList head,tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DoubleLinkedList node = cache.get(key);
        if (node == null){
            return -1;
        }
        //如果在缓存中，则通过定位在哪，然后移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = cache.get(key);
        if (node == null){
            //如果不存在，创建节点，加入缓存，并且加入表头
            DoubleLinkedList newNode = new DoubleLinkedList(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                //容量不够，删除尾节点
                DoubleLinkedList removeTail = removeTail();
                cache.remove(removeTail.key);
                --size;
            }
        } else {
            //如果存在，移动到头部
            node.value = value;
            moveToHead(node);
        }

    }

    private void moveToHead(DoubleLinkedList node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DoubleLinkedList node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DoubleLinkedList removeTail(){
        DoubleLinkedList res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {


    }
}
