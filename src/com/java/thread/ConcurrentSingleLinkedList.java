package com.java.thread;

import javax.xml.soap.Node;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在链表实现的基础上加锁，所有设计到链表结构变化的地点加锁，例如，新增，删除等操作。
 * 例如：借助ReentrantLock()可重入锁对新增结点加锁，避免冲突。​
 * 细粒度锁，锁住需要修改的节点. 将锁放到node里，每次需要修改的仅仅是部分节点，而不用
 * 把整个list锁住，这样能保证互不干扰的goroutine们可以同时处理list，而会互相干扰的goroutine
 * 则会被节点的mutex阻塞，以保证不存在竟态数据。当然，为了保证不会有多个goroutine同时处理一个节点，
 * 我们需要在取得要修改节点的锁之前先取得前项节点的锁，然后才能取得修改节点的锁。这个步骤很像交叉手，
 * 它被称为锁耦合。
 */
public class ConcurrentSingleLinkedList {
    final static Lock lock = new ReentrantLock();
    Node head = null;
    static class Node {
        Node next = null;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        try {
            lock.lock();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp =temp.next;
            }
            temp.next = newNode;
        } finally {
            lock.unlock();
        }
    }
}
