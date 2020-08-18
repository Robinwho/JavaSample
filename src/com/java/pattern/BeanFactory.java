package com.java.pattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 懒汉式的变种
 * spring IOC容器就是使用的这种注册式的单例模式
 */
public class BeanFactory {
    public static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(String className){
        if(!ioc.containsKey(className)){
            try {
                Object instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
                return instance;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return ioc.get(className);
    }
}
