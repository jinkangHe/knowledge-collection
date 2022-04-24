package com.knowledge.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Proxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        //如果方法有返回值 可以返回  如果没有 就忽略
        Object o1 = methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return o1;
    }
}
