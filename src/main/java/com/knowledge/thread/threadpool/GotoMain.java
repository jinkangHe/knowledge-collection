package com.knowledge.thread.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/4 20:55
 */

public class GotoMain {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        int j = 0;
        retry:
        for (; i < 20; i++) {
            System.out.println("i = " + i);
            System.out.println("j循环开始");

            for (; j < 20; j++) {
                System.out.println("j = " +  j);

                if (j % 3 == 2) {
                    continue retry;
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("j循环结束");
        }
        System.out.println("i循环结束");
    }
}
