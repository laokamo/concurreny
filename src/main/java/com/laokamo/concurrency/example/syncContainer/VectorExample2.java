package com.laokamo.concurrency.example.syncContainer;

import com.laokamo.concurrency.annoations.NotThreadSafe;
import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class VectorExample2 {

    private static Vector vector = new Vector();

    public static void main(String[] args) {
        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {//问题点
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {//问题点
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();

        }
    }
}
