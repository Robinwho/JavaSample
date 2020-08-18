/* package com.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.java.thread.ThreadPrintType2.lock;

public class SyncThreadTestReentrantLock {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.start();
        b.start();
        c.start();
        System.out.print("over\n");
    }
}

static class ThreadA extends Thread {
    @Override
    public void run() {
        //TODO Auto-generated
        super.run();
        int i = 0;
        while (i < 10) {
            lock.lock();
            if (state % 3 == 0) {
                System.out.print("thread a run" + "\n");
                state++;
                i++;
            }
            lock.unlock();
        }
    }
}

static class ThreadB extends Thread {
    @Override
    public void run() {
        //TODO Auto-generated
        super.run();
        int i = 0;
        while (i < 10) {
            lock.lock();
            if (state % 3 == 1) {
                System.out.print("thread b run" + "\n");
                state++;
                i++;
            }
            lock.unlock();
        }
    }
}

static class ThreadC extends Thread {
    @Override
    public void run() {
        //TODO Auto-generated
        super.run();
        int i = 0;
        while (i < 10) {
            lock.lock();
            if (state % 3 == 0) {
                System.out.print("thread c run" + "\n");
                state++;
                i++;
            }
            lock.unlock();
        }
    }
}
*/