package com.laokamo.concurrency.example.publish;

import com.laokamo.concurrency.annoations.NotRecommend;
import com.laokamo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass() {
            log.info("{}",Escape.this.thisCanEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
