package com.knowledge.collection.thread.base;

public class CustomRunnable implements Runnable{



    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
