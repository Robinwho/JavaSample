package com.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁方式
 */
public class ThreadPrintType2 {
    static Lock lock = new ReentrantLock();
    static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; ) {
                try {
                    lock.lock();
                    while (state % 3 == 0) {
                        System.out.print("a");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; ) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("b");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; ) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.print("c");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}