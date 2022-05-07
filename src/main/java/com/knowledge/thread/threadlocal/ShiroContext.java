package com.knowledge.thread.threadlocal;

import org.springframework.util.Assert;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/5/6 10:58
 */

public class ShiroContext {
    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public void clearContext() {
        contextHolder.remove();
    }

    public Authentication getContext() {
        Authentication ctx = contextHolder.get();

        if (ctx == null) {
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }

        return ctx;
    }

    public void setContext(Authentication authentication) {
        Assert.notNull(authentication, "Only non-null SecurityContext instances are permitted");
        contextHolder.set(authentication);
    }

    public Authentication createEmptyContext() {
        return new Authentication();
    }
}
