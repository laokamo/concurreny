package com.laokamo.concurrency.example.singleton;

import com.laokamo.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉单例模式
 * 第一次调用方法时创建
 */
@NotThreadSafe
public class SingletonExample1 {

    private static SingletonExample1 instance = null;

    //私有构造方法
    private SingletonExample1() {

    }

    //静态工程方法
    public static SingletonExample1 getInstance(){
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
