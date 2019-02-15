package com.laokamo.concurrency.example.atomic;

import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * AtomicReference
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {
    private static AtomicReference<Integer> reference = new AtomicReference<>(0);

    public static void main(String[] args) {
        reference.compareAndSet(0, 2);
        reference.compareAndSet(2, 4);
        reference.compareAndSet(4, 8);
        log.info("count:{}",reference.get());
    }

}
