# JavaSample
[![MIT](https://img.shields.io/badge/license-MIT-5eba00.svg)](https://github.com/GokuMohandas/practicalAI/blob/master/LICENSE)
[![HitCount](http://hits.dwyl.com/Robinwho/JavaSample.svg)](http://hits.dwyl.com/Robinwho/JavaSample)
[![Build Status](https://travis-ci.org/Wechat-Group/WxJava.svg?branch=develop)](https://travis-ci.org/Wechat-Group/WxJava)

# 简介
- 🔥 New：此项目将Java常用设计模式、数据结构、分布式、算法、JVM、缓存技术等核心基础针对性做了实现。并均可直接运行。

# 使用说明

- git或下载项目：
>$ git clone https://github.com/Robinwho/JavaSample.git

本地打开运行即可。

# 模块列表
## 分布式
### LRU1
- 用java自己实现一个LRU。

### LRUCache
- 通过 HashMap 实现一个缓存类 LRUCache ，我们通过逻辑处理，对最少使用的数据进行删除。

### LRUNode
- 保证基本的Cache容量，如果超过容量则必须丢掉最不常用的缓存数据，再添加最新的缓存。每次读取缓存都会改变缓存的使用时间，将
缓存的存在时间重新刷新。通过双向链表的数据结构实现 LRU Cache，链表头（head）保存最新获取和存储的数据值，链表尾（tail）
既为最不常使用的值，当需要清理时，清理链表的 tail 即可，并将前一个元素设置为tail。

## 设计模式
### BeanFactory
- 懒汉式的变种，spring IOC容器就是使用的这种注册式的单例模式

### Hungry
- 单例模式：饿汉式。在类加载时，就创建单例对象，执行效率高，但是占空间，以空间换时间，线程安全。

### Lazy1
- 单例模式：懒汉式。双重判断，对象使用的时候，才去创建。有线程安全的风险，需要加锁。

### Lazy2
- 单例模式：懒汉式。静态内部类，在使用时，才加载。此种模式，既是懒加载，又没有加锁影响性能。

## 线程模型
- 用三个线程按顺序循环打印abc三个字母，比如abcabcabc。使用同步块和wait、notify的方法控制三个线程的执行次序。具体方法如下：
从大的方向上来讲，该问题为三线程间的同步唤醒操作，主要的目的就是ThreadA->ThreadB->ThreadC->ThreadA循环执行三个线程。

### ABC_Synch
- synchronized 搭配wait/notify实现。

### ConcurrentSingleLinedList
- 并发安全的链表。在链表实现的基础上加锁，所有设计到链表结构变化的地点加锁，例如，新增，删除等操作。例如：借助ReentrantLock()
可重入锁对新增结点加锁，避免冲突。

### SyncThreadTest
- 信号量Sephmore。开启多个线程，如果保证顺序执行，有哪几种实现方式，或者如何保证多个线程都执行完再拿到结果。

### SyncThreadTestReentrantLock
- 使用ReentrantLock可重入锁。

### ThreadPrintType2
- lock锁方式

# 联系
- 🔥🔥🔥🔥🔥🔥🔥🔥 因工作繁忙，更新有延迟。公众号【未名小猪】更方便 
- 🔥🔥🔥🔥🔥🔥🔥🔥 欢迎大家关注留言，工作生活随想，与大家交流 

![](https://github.com/Robinwho/Deep-Learning/blob/master/pkupig.jpg)
