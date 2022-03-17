package com.knowledge.aop;

import com.knowledge.aop.handler.AspectHandler;
import com.knowledge.aop.service.ApplicationService;
import com.knowledge.aop.service.impl.ApplicationServiceImpl;

public class Demo {
    public static void main(String[] args) {
        ApplicationService applicationService = new ApplicationServiceImpl();
        ApplicationService $applicationService = (ApplicationService)new AspectHandler().newProxyInstance(applicationService);
        $applicationService.print("print");
    }
}
