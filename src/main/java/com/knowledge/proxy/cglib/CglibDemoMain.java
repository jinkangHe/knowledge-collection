package com.knowledge.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

public class CglibDemoMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new Proxy());
        Target target = (Target) enhancer.create();
        String tty = target.service("tty");
        System.out.println(tty);
    }
}
