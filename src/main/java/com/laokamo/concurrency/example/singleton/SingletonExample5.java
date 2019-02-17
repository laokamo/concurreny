package com.laokamo.concurrency.example.singleton;

import com.laokamo.concurrency.annoations.ThreadSafe;

/**
 * 懒汉单例模式 ————双重检测锁单例模式
 * 第一次调用方法时创建
 *
 * 指令重排导致线程安全问题 加volatile解决指令重排问题
 */
@ThreadSafe
public class SingletonExample5 {

    //volatile+双重检测机制 来 禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    //私有构造方法
    private SingletonExample5() {

    }

    //静态工程方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { //双重检测机制
            synchronized (SingletonExample5.class) {//同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
