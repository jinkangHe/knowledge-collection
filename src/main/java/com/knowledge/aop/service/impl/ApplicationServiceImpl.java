package com.knowledge.aop.service.impl;

import com.knowledge.aop.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
