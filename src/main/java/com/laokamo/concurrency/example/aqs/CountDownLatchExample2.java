package com.laokamo.concurrency.example.aqs;

import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@ThreadSafe
public class CountDownLatchExample2 {

    private static int threadClient = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(threadClient);

        for (int i = 0; i < threadClient; i++) {
            final int finalI = i;
            service.execute(()->{
                try {
                    test(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(1, TimeUnit.MILLISECONDS);//给定时间的等待
        log.info("finish");
        service.shutdown();
    }


    private static void test(int i) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", i);
        //Thread.sleep(100);
    }
}
