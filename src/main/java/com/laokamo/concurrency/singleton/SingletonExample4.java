package com.laokamo.concurrency.singleton;

import com.laokamo.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉单例模式 ————双重检测锁单例模式
 * 第一次调用方法时创建
 *
 * 指令重排导致线程安全问题
 */
@NotThreadSafe
public class SingletonExample4 {

    private static SingletonExample4 instance = null;

    //私有构造方法
    private SingletonExample4() {

    }

    //静态工程方法
    public static SingletonExample4 getInstance() {
        if (instance == null) { //双重检测机制
            synchronized (SingletonExample4.class) {//同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
