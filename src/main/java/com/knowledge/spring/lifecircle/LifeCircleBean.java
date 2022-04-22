package com.knowledge.spring.lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:48
 */
@Component
public class LifeCircleBean implements BeanNameAware,BeanDefinitionRegistryPostProcessor
        , ApplicationContextAware
        , BeanFactoryAware
        , InitializingBean {

    @Autowired
    private PropertyForLifeCircle propertyForLifeCircle;


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("==============执行BeanDefinitionRegistryPostProcessor接口方法==============");

        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        System.out.println("BeanDefinition配置完成！共读取到" + registry.getBeanDefinitionCount() + "个");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    public PropertyForLifeCircle getPropertyForLifeCircle() {
        return propertyForLifeCircle;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("==============执行BeanNameAware接口方法==============");
        System.out.println("当前Bean在上下文中的BeanName为：" + name);
        System.out.println("此时的属性[propertyForLifeCircle]为：" + getPropertyForLifeCircle());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("==============执行ApplicationContextAware接口方法==============");
        System.out.println("获取到了上下文：【" + applicationContext + "】，如果这是一个上下文工具类，可以用到");
        System.out.println("此时的属性[propertyForLifeCircle]为：" + getPropertyForLifeCircle());

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("==============执行BeanFactoryAware接口方法==============");

        System.out.println("获取到了bean工厂：【" + beanFactory + "】，如果这是一个工厂工具类，可以用到");
        System.out.println("此时的属性[propertyForLifeCircle]为：" + getPropertyForLifeCircle());

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==============执行InitializingBean接口方法==============");
        System.out.println("属性设置完成！");
        System.out.println("此时的属性[propertyForLifeCircle]为：" + getPropertyForLifeCircle());
    }


}
