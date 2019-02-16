package com.laokamo.concurrency.singleton;

import com.laokamo.concurrency.annoations.ThreadSafe;

/**
 * 饿汉单例模式
 * 类装载时创建
 */
@ThreadSafe
public class SingletonExample2 {

    private static SingletonExample2 instance = new SingletonExample2();

    //私有构造方法
    private SingletonExample2() {
        //建议构造函数没有过多的处理 同时方法会被调用 不然会造成资源的浪费
    }

    //静态工程方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
