package com.java.thread;

import java.util.concurrent.Semaphore;

public class SyncThreadTest {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();

        try {
            B.acquire();
            C.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.start();
        b.start();
        c.start();
        System.out.print("over\n");
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.print("Thread a run" + i + "\n");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.print("Thread b run" + i + "\n");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.print("Thread c run" + i + "\n");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
