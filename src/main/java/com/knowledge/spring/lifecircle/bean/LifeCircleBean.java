package com.knowledge.spring.lifecircle.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:48
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LifeCircleBean {
}
