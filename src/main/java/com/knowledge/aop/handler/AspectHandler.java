package com.knowledge.aop.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AspectHandler implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName() + "start");
        method.invoke(target,args);
        System.out.println(proxy.getClass().getName() + "end");

        return null;
    }

    public Object newProxyInstance(Object obj) {
        this.target = obj;
        return Proxy.newProxyInstance(
                // 指定代理对象的类加载器
                obj.getClass().getClassLoader(),
                // 代理对象需要实现的接口，可以同时指定多个接口
                obj.getClass().getInterfaces(),
                // 方法调用的实际处理者，代理对象的方法调用都会转发到这里
                this);
    }
}
