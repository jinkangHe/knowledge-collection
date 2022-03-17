package com.knowledge.httpclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/8 12:37
 */

public class HttpClientDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {

        Logger logger = LoggerFactory.getLogger(HttpClientDemo.class);



        new Thread(() -> {
            CountDownLatch countDownLatchForLove = new CountDownLatch(1000);
            for (int j = 0; j < 1000; j++) {
                LoveRunnable loveRunnable = new LoveRunnable(countDownLatchForLove);
                Thread thread = new Thread(loveRunnable,"thread-" + j);
                thread.start();
                System.out.println(thread.getName() + "已创建");
                countDownLatchForLove.countDown();
                if (countDownLatchForLove.getCount() == 0) {
                    System.out.println("countDownLatchForLove已释放");
                }
            }
        }).start();


        new Thread(()->{
            CountDownLatch countDownLatchForComment = new CountDownLatch(1000);
            for (int i = 0; i < 1000; i++) {
                CommentRunnable commentRunnable = new CommentRunnable(countDownLatchForComment);
                Thread thread = new Thread(commentRunnable,"thread-" + i);
                thread.start();
                System.out.println(thread.getName() + "已创建");
                countDownLatchForComment.countDown();
                if (countDownLatchForComment.getCount() == 0) {
                    System.out.println("countDownLatchForLove已释放");
                }
            }
        }).start();

    }


}
