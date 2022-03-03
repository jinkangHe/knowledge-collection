package com.knowledge.collection.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * callable 一般用于耗时的计算 有返回值
 */
public class CustomCallable implements Callable<Double> {
    @Override
    public Double call() throws InterruptedException {
        double total = 10;
        //计算结果
        double result = 0;
        while (result < total) {
            //模拟耗时的计算
            double random = Math.random();
            result += random;
            TimeUnit.MILLISECONDS.sleep(500);
        }
        return result;
    }
}
