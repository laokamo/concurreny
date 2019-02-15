package com.laokamo.concurrency.publish;

import com.laokamo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 线程不安全的发布对象
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private static String[] states = {"a", "b", "c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish publish = new UnsafePublish();
        log.info("states={}", Arrays.toString(publish.getStates()));

        publish.getStates()[0] = "e";
        log.info("states={}", Arrays.toString(publish.getStates()));
    }

}
