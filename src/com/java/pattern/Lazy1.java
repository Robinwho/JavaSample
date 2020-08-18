package com.java.pattern;

/**
 * 单例模式：懒汉式  双重判断
 * 对象使用的时候，才去创建
 * 有线程安全的风险，需要加锁
 */
public class Lazy1 {
    private Lazy1(){}

    private static Lazy1 instance = null;

    public static Lazy1 getInstance(){
        if(instance == null){
            synchronized (Lazy1.class){
                if(instance == null) {
                    instance = new Lazy1();
                }
            }
        }
        return instance;
    }
}
