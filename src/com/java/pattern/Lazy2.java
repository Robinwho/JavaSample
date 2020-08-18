package com.java.pattern;

/**
 *单例模式：懒汉式  静态内部类
 * 静态内部类在使用时，才加载
 * 此种模式，既是懒加载，又没有加锁影响性能
 */
public class Lazy2 {
    private Lazy2(){}

    public static final Lazy2 getInstance(){
        return LazyLoad.instance;
    }

    private static class LazyLoad{
        private static final Lazy2 instance = new Lazy2();
    }
}
