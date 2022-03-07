package com.knowledge.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:52
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(value = "com.knowledge.spring.*")
public class AppStarter  {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }
}
