package com.knowledge.spring.json;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/9 15:24
 */
@Data
public class LocalDateEntity {
    private LocalDate date;
    private LocalDateTime dateTime;
}
