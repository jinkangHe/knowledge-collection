package com.knowledge.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * 可以设置每个方法对应的方法增强器
 */
public class CglibCallBackFilterDemo {
    public static void main(String[] args) {
        CallbackFilter callbackFilter = method -> {
            if (method.getName().equals("save")) {
                // 返回第一个
                return 0;
            }
            if (method.getName().equals("update")) {
                // 返回第二个
                return 1;
            }
            return 0;
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        Callback[] callbacks = {new ProxyForSave(),new ProxyForUpdate()};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(callbackFilter);
        Target target = (Target) enhancer.create();
        //使用第0个增强
        target.save();
        //使用第1个增强
        target.update();
        //默认0
        target.service("service");
    }
}
