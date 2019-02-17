package com.laokamo.concurrency.immutable;

import com.google.common.collect.Maps;
import com.laokamo.concurrency.annoations.NotThreadSafe;
import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static  Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 5);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1, 6);//修改操作会抛出异常
        log.info("{}", map.get(1));
    }



}
