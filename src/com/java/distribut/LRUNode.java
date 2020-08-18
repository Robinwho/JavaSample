package com.java.distribut;

/**
 * 定义一个链表类，包含head(指针的上一个对象)，tail(指针的下一个对象)类种类
 */
public class LRUNode {
    public String key;
    public Object value;
    // 当前对象的上一个对象
    LRUNode prev;
    // 当前对象的下一个对象
    LRUNode next;

    /**
     * 带有参数的构造器
     */
    public LRUNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
