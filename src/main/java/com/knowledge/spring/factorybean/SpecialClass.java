package com.knowledge.spring.factorybean;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 不用加@Component也能正常注入
 */
public class SpecialClass {

    private LocalDateTime now;

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public LocalDateTime getNow() {
        return now;
    }
}
