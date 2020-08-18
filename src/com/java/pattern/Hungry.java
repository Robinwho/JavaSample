package com.java.pattern;

/**
 * 单例模式：饿汉式
 * 在类加载时，就创建单例对象
 * 执行效率高，但是占空间，以空间换时间
 * 线程安全
 */
public class Hungry {
    private static final Hungry hungry = new Hungry();

    private Hungry(){}

    public static Hungry getInstance(){
        return hungry;
    }
}
