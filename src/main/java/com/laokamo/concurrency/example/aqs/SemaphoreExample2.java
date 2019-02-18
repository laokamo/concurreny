package com.laokamo.concurrency.example.aqs;

import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class SemaphoreExample2 {

    private static int threadClient = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadClient);

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadClient; i++) {
            final int finalI = i;
            service.execute(()->{
                try {
                    semaphore.acquire(3);//获取多个许可
                    test(finalI);
                    semaphore.release(3);//释放多个许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        service.shutdown();
    }


    private static void test(int i) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", i);
        Thread.sleep(100);
    }
}
