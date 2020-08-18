package com.java.distribut;

import java.util.HashMap;

/**
 * 实现 LRU策略 清除缓存（当缓存大小>=指定大小时）
 */
public class LRUCache {
    private int capacity;

    //用来存储 key 和 LRUNode对象 充当缓存，且 hashmap 中的数据不会自动清理，需要我们手动清理
    private HashMap<String, LRUNode> hashMap;

    //数据链表第一个对象
    private LRUNode head;

    //数据链表最后一个对象
    private LRUNode tail;

    //带参数capacity构造器
    public LRUCache(int capacity) {
        this.capacity = capacity;

        //创建对象时，创建一个hashmap充当缓存
        hashMap = new HashMap<String, LRUNode>();
    }

    /**
     * 向链表中插入数据
     */
    public void set(String key, Object value) {
        //通过key查询链表中是否存在此对象
        LRUNode lruNode = hashMap.get(key);

        //缓存中有值 替换旧值 更新链表指针
        if(lruNode != null) {
            lruNode.value = value;
            appendTail(lruNode, false);
        } else { //缓存中无此值，新对象，判断hashMap是否大于缓存大小
            lruNode = new LRUNode(key, value);
            if(hashMap.size() >= capacity) {
                appendTail(tail, true);
            }

            //存取新值
            hashMap.put(key, lruNode);
        }

        //将新值设置为head
        setHead(lruNode);
    }

    /**
     *  更新链表的前后指针，新增数据公用
     */
    public void appendTail(LRUNode lNode, boolean flag) {
        //存在上一个对象prev
        if (lNode.prev != null) {
            lNode.prev.next = lNode.next;
        } else {
            head = lNode.next;
        }

        if (lNode.next != null) {
            lNode.next.prev = lNode.prev;
        } else {
            tail = lNode.prev;
        }
        lNode.prev = null;
        lNode.next = null;

        //如内存不足，需删除tail
        if(flag) {
            hashMap.remove(lNode.key);
        }
    }

    /**
     * 设置链表的 头 节点
     */
    public void setHead(LRUNode node) {
        if (node != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }
}
