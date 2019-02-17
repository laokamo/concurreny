package com.laokamo.concurrency.example.singleton;

import com.laokamo.concurrency.annoations.NotRecommend;
import com.laokamo.concurrency.annoations.ThreadSafe;

/**
 * 懒汉单例模式
 * 第一次调用方法时创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    //私有构造方法
    private SingletonExample3() {

    }

    //静态工程方法
    public  static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
