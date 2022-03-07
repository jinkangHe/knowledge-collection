package com.knowledge.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 14:10
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建一个CountDownLatch计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatchApplication app = new CountDownLatchApplication(countDownLatch);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(app, "线程" + i);
            thread.start();
            //每创建启动（此时是等待状态）一个线程 计数器减一 当计数器为0时  所有线程开始运行
            countDownLatch.countDown();
            System.out.println(thread.getName() + "准备就绪");
            TimeUnit.SECONDS.sleep(1);
        }


    }
}
