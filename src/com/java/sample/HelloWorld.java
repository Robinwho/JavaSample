package com.java.sample;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        System.out.println(System.currentTimeMillis());
        //try {
            Thread.currentThread().sleep(600000);
        //}

        System.out.println(System.currentTimeMillis());
    }
}
