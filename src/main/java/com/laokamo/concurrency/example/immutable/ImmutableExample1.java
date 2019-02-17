package com.laokamo.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.laokamo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 5);
    }

    public static void main(String[] args) {
        //a = 2;
        //b = "555";
        //map = Maps.newHashMap();
        map.put(1, 6);
        log.info("{}", map.get(1));
    }


    public void test(final int d) {
        //d = 2;
    }
}
