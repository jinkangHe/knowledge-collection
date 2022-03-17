package com.knowledge.spring.lifecircle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:25
 */
@Component
public class AfterStart implements CommandLineRunner {
    @Autowired
    ApplicationContext applicationContext;
    @Override
    public void run(String... args) {
        Object bean = applicationContext.getBean("testFactoryBean");
        System.out.println("bean = " + bean);

    }
}
