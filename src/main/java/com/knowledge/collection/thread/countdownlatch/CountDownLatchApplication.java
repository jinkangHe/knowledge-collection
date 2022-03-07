package com.knowledge.collection.thread.countdownlatch;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 14:11
 */

public class CountDownLatchApplication implements Runnable{

    private CountDownLatch countDownLatch;
    @Override
    public void run() {
        try {
            //任务先等待
            countDownLatch.await();
            for (;;){
                System.out.println(Thread.currentThread().getName() + "running");
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public CountDownLatchApplication(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
