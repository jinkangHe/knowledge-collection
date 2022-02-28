package com.knowledge.collection.thread.base;

public class CustomThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + "正在运行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
