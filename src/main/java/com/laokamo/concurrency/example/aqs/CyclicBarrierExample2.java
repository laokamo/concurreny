package com.laokamo.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExample2 {

    private static int threadClient = 20;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < threadClient; i++) {
            final int number = i;
            Thread.sleep(1000);
            service.execute(()->{
                try {
                    race(number);
                } catch (Exception e) {
                    log.error("exception",e);
                }
            });
        }
        log.info("finish");
        service.shutdown();
    }

    private static void race(int i) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", i);
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);//
        } catch (Exception e) {
            log.error("{}", e);
        }

        log.info("{} continue ",i);
    }
}
