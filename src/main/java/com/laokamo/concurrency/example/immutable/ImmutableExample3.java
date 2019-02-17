package com.laokamo.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.laokamo.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private static final ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

    public static void main(String[] args) {
        list.add(4);
        set.add(6);
    }


}
