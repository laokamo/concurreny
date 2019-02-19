package com.laokamo.concurrency.example.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 死锁
 */
@Slf4j
public class DeadLock implements Runnable{

    private int flag = 1;

    private static Object o1 = new Object();
    private static Object o2 = new Object();


    @Override
    public void run() {
        log.info("flag:{}", flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("{}",1);
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    log.info("{}",2);
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 1;
        deadLock2.flag = 0;
        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }
}
