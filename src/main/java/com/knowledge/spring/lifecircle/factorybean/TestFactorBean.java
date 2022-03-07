package com.knowledge.spring.lifecircle.factorybean;

import com.knowledge.spring.lifecircle.bean.LifeCircleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:19
 */
@Lazy(value = false)
@Component
public class TestFactorBean extends AbstractFactoryBean<LifeCircleBean> {
    Logger logger = LoggerFactory.getLogger(TestFactorBean.class);
    @Override
    public void afterPropertiesSet() {
        logger.info("afterPropertiesSet...");
    }

    @Override
    public Class<?> getObjectType() {
        return LifeCircleBean.class;
    }

    @Override
    protected LifeCircleBean createInstance() {
        logger.info("createInstance...");
        LifeCircleBean lifeCircleBean = new LifeCircleBean();
        return lifeCircleBean;
    }
}
