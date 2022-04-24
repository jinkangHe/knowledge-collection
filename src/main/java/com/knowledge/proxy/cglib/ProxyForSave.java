package com.knowledge.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyForSave implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before Save");
        //如果方法有返回值 可以返回  如果没有 就忽略
        Object o1 = proxy.invokeSuper(obj,args);
        System.out.println("after Save");
        return null;
    }
}
