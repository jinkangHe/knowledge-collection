package com.knowledge.spring.factorybean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:25
 */
@Component
public class FactoryBeanRunner implements CommandLineRunner {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    SpecialClass specialClass;

    @Override
    public void run(String... args) throws InterruptedException {
        /*
        正常情况下 这个应该是返回SpecialClassFactoryBean的一个实例对象，但实际返回的是SpecialClass这个类
         */
        Object bean = applicationContext.getBean("specialClassFactoryBean");
        System.out.println("通过FactoryBean name获取的对象是 = " + bean);
        SpecialClass specialClass = (SpecialClass)bean;

        /*
         * 类上面不用加@Component也能正常注入
         */
        System.out.println("注入的SpecialClass对象也能正常使用 = " + specialClass);
        System.out.println(specialClass.getNow());
        /*
        如果想获取FactoryBean的实例，需要在name前加一个&符号
         */
        Object beanFactory = applicationContext.getBean("&specialClassFactoryBean");
        System.out.println("加了&之后获取的对象是 = " + beanFactory);


    }
}
