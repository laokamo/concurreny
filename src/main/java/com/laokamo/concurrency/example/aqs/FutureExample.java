package com.laokamo.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample {

    static class MyFuture implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(2000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new MyFuture());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("{}",result);
        service.shutdown();
    }
}
