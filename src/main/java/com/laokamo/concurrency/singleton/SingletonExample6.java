package com.laokamo.concurrency.singleton;

import com.laokamo.concurrency.annoations.ThreadSafe;

/**
 * 饿汉单例模式
 */
@ThreadSafe
public class SingletonExample6 {

    //volatile+双重检测机制 来 禁止指令重排序
    private volatile static SingletonExample6 instance = null;

    //静态域和静态块的执行顺序 按书写顺序执行 注意！
    static {
        instance = new SingletonExample6();
    }

    //私有构造方法
    private SingletonExample6() {

    }

    //静态工程方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
