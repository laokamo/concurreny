package com.laokamo.concurrency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 子类无法继承父类的synchronized方法 需子类显示的声明
 */
@Slf4j
public class SynchronizedExample2 {

    //修饰一个类
    private static void test1() {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {}", i);
            }
        }
    }

    //修饰静态方法
    private static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            example1.test2();
        });
        service.execute(() -> {
            example1.test2();
        });
    }
}
