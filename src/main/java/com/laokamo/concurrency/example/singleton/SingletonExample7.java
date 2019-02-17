package com.laokamo.concurrency.example.singleton;

import com.laokamo.concurrency.annoations.Recommend;
import com.laokamo.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式 最安全的
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造方法
    private SingletonExample7() {

    }

    //静态工程方法
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }


}
