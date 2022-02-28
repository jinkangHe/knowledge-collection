package com.knowledge.collection.thread.base;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        double random = Math.random();
        long duration = (long) (random*10000l);
        Thread.sleep(duration);
        return Thread.currentThread().getName() + "沉睡了" + duration + "ms";
    }
}
