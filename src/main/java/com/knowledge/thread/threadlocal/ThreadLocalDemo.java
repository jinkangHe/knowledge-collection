package com.knowledge.thread.threadlocal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/4/25 23:01
 */

public class ThreadLocalDemo {

    public static void main(String[] args) {

        //模拟一个接收到请求 tomcat开启了一个线程
        new Thread(() -> {

            //模拟登录认证
            Authentication authentication = login("hjk", "manager");
            // 保存登录认证信息
            SecurityContext.setContext(authentication);

            //业务
            doService();
            doQuery();
        }).start();

        new Thread(() -> {
            //模拟登录认证
            Authentication authentication = login("蟑螂恶霸", "boss");

            // 保存登录认证信息
            SecurityContext.setContext(authentication);

            //业务
            doService();
            doQuery();
            try {
                TimeUnit.MINUTES.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static void doService() {
        Authentication context = SecurityContext.getContext();
        System.out.println("当前登录人：" + context + "处理业务");
    }

    private static void doQuery() {
        Authentication context = SecurityContext.getContext();
        System.out.println("当前登录人：" + context + "进行查询");
    }

    public static Authentication login(String username, String role) {
        return new Authentication(username, role);
    }
}
