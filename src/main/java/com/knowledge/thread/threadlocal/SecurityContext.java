package com.knowledge.thread.threadlocal;

import org.springframework.util.Assert;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/5/6 10:58
 */

public class SecurityContext {
    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public static void clearContext() {
        contextHolder.remove();
    }

    public static  Authentication getContext() {
        Authentication ctx = contextHolder.get();

        if (ctx == null) {
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }

        return ctx;
    }

    public static void setContext(Authentication authentication) {
        Assert.notNull(authentication, "Only non-null SecurityContext instances are permitted");
        contextHolder.set(authentication);
    }

    public static  Authentication createEmptyContext() {
        return new Authentication();
    }
}
