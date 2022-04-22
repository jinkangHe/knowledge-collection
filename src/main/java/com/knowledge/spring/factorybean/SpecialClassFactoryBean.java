package com.knowledge.spring.factorybean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 这个接口是为了解决有些复杂，特殊的Bean交给Spring使用通用的方式进行创建会很麻烦
 * 可以在这里使用自定义编码的方式进行自定义的创建
 * 创建过程在
 * @See com.knowledge.spring.factorybean.SpecialClassFactoryBean#createInstance()
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:19
 *
 */

@Component
public class SpecialClassFactoryBean extends AbstractFactoryBean<SpecialClass> {
    Logger logger = LoggerFactory.getLogger(SpecialClassFactoryBean.class);



    @Override
    public Class<?> getObjectType() {
        return SpecialClass.class;
    }

    @Override
    protected SpecialClass createInstance() {
        logger.info("createInstance...");
        SpecialClass specialClass = new SpecialClass();
        specialClass.setNow(LocalDateTime.now());
        return specialClass;
    }
}
