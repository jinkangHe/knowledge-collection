package com.knowledge.collection.thread.threadpool;

import com.knowledge.collection.thread.base.CustomCallable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池基本参数
 * 1.corePoolSize:核心线程数，线程池维护的最小线程数量，核心线程创建后不会被回收（注意：设置allowCoreThreadTimeout=true后，空闲的核心线程超过存活时间也会被回收）。
 * 大于核心线程数的线程，在空闲时间超过keepAliveTime后会被回收。
 * 线程池刚创建时，里面没有一个线程，当调用 execute() 方法添加一个任务时，如果正在运行的线程数量小于corePoolSize，则马上创建新线程并运行这个任务。
 * <p>
 * 2.maximumPoolSize:最大线程数，当调用 execute() 方法添加一个任务时，如果正在运行的线程数量大于corePoolSize，小于maximumPoolSize，并且线程池没有空闲线程，工作队列（workQueue）满了的情况则创建新线程并运行这个任务。
 * <p>
 * 3.keepAliveTime：空闲线程存活时间，当空闲的线程超过这个时间，则会被回收 （allowCoreThreadTimeout不为true核心线程不会被回收）
 * <p>
 * 4.unit：时间单位  keepAliveTime的时间单位
 * <p>
 * <p>
 * 5.workQueue：工作队列 核心线程满了之后，被execute()方法提交的Runnable任务会放在workQueue
 * <p>
 * <p>
 * 6.threadFactory：线程工厂  创建线程的工厂
 * <p>
 * 7.handler：拒绝策略 当核心线程满了，工作队列满了 ，最大线程数也满了之后 执行的拒绝策略。可以自定义拒绝策略，拒绝策略需要实现RejectedExecutionHandler接口。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger number = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5
                , 10
                , 10
                , TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)
                , r -> new Thread(r, "thread-" + number.getAndIncrement())
                , (r, executor) -> {
                    int maximumPoolSize = executor.getMaximumPoolSize();
                    long taskCount = executor.getTaskCount();
                    System.out.println("maximumPoolSize=" + maximumPoolSize);
                    System.out.println("taskCount=" + taskCount);
                });

        CustomCallable customCallable = new CustomCallable();
        for (int i = 0; i < 40; i++) {
            Future<Double> submit = threadPoolExecutor.submit(customCallable);
            new Thread(() -> {
                while (true) {
                    if (submit.isDone()) {
                        try {
                            System.out.println(Thread.currentThread() + "执行的计算任务" + submit.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }).start();
        }

        new Thread(() -> {
            while (true) {
                int queueSize = threadPoolExecutor.getQueue().size();

                System.out.print("当前队列任务数：" + queueSize + "  ");

                int activeCount = threadPoolExecutor.getActiveCount();

                System.out.print("当前活动线程数：" + activeCount + "  ");

                long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();

                System.out.print("执行完成线程数：" + completedTaskCount + "  ");

                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();

                System.out.print("最大线程数：" + maximumPoolSize + "  ");


                long taskCount = threadPoolExecutor.getTaskCount();

                System.out.println("总线程数：" + taskCount + "  ");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


}
