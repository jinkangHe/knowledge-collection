package com.knowledge.thread.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadBase {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        创建线程的方式
         */
        //threadMethod();
        //runnableMethod();
        callableMethod();
    }

    /**
     * 1.继承Thread类
     */
    private static void threadMethod() {
        CustomThread customThread1 = new CustomThread();
        customThread1.setName("t1");
        customThread1.start();
        CustomThread customThread2 = new CustomThread();
        customThread2.setName("t2");
        customThread2.start();
    }

    /**
     * 2.实现Runnable接口
     */
    private static void runnableMethod() {
        CustomRunnable customRunnable = new CustomRunnable();
        Thread thread1 = new Thread(customRunnable, "t3");
        Thread thread2 = new Thread(customRunnable, "t4");
        thread1.start();
        thread2.start();
    }


    private static void callableMethod() throws ExecutionException, InterruptedException {
        CustomCallable customCallable = new CustomCallable();
        FutureTask<Double> futureTask1 = new FutureTask(customCallable);
        FutureTask<Double> futureTask2 = new FutureTask(customCallable);

        Thread thread1 = new Thread(futureTask1, "t5");
        Thread thread2 = new Thread(futureTask2, "t6");
        thread1.start();
        thread2.start();

        // 启动另外一个线程去监听任务状态
        new Thread(() -> {
            while (true) {
                if (futureTask1.isDone()) {
                    try {
                        System.out.println(Thread.currentThread() + "futureTask1" + futureTask1.get());
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();
        new Thread(() -> {
            while (true) {
                if (futureTask2.isDone()) {
                    try {
                        System.out.println(Thread.currentThread() + "futureTask2" + futureTask2.get());
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        // get方法会阻塞当前线程  所以需要放在最后
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

    }
}
