package com.java.thread;

/**
 *使用同步块和wait、notify的方法控制三个线程的执行次序。
 * 具体方法如下：从大的方向上来讲，
 * 该问题为三线程间的同步唤醒操作，主要的目的就是
 * ThreadA->ThreadB->ThreadC->ThreadA循环执行三个线程。
 * 为了控制线程执行的顺序，那么就必须要确定唤醒、等待的顺序，
 * 所以每一个线程必须同时持有两个对象锁，才能进行打印操作。
 * 一个对象锁是prev，就是前一个线程所对应的对象锁，其主要作
 * 用是保证当前线程一定是在前一个线程操作完成后（即前一个线程
 * 释放了其对应的对象锁）才开始执行。还有一个锁就是自身对象锁。
 * 主要的思想就是，为了控制执行的顺序，必须要先持有prev锁（也就
 * 前一个线程要释放其自身对象锁），然后当前线程再申请自己对象锁，
 * 两者兼备时打印。之后首先调用self.notify()唤醒下一个等待线程
 * （注意notify不会立即释放对象锁，只有等到同步块代码执行完毕后才
 * 会释放），再调用prev.wait()立即释放prev对象锁，当前线程进入
 * 休眠，等待其他线程的notify操作再次唤醒。 ​
 */
public class ABC_Synch {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;
        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取prev锁
                    synchronized (self) {// 再获取self锁
                        System.out.print(name); // 打印
                        count--;

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放
                    }
                    //此时执行完self同步块，self锁才释放
                    try {
                        prev.wait(); // 立即释放prev锁，当前线程休眠，等待唤醒
                        /**
                         * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);

        //return;
    }
}
