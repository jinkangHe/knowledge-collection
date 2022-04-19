package com.knowledge.spring.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/4/19 19:28
 */

public class LocalDateRunDemo implements CommandLineRunner {

    // 一定要自动注入的才行 new出来的依然是默认序列化方式
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        LocalDateEntity localDateEntity = new LocalDateEntity();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        localDateEntity.setDate(localDate);
        localDateEntity.setDateTime(localDateTime);
        ObjectMapper mapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(localDateEntity);
        System.out.println("序列化=" + s);

        String json = "{\"date\":\"2022-03-09\",\"dateTime\":\"2022-03-09 15:54:51\"}";
        LocalDateEntity obj = objectMapper.readValue(json, LocalDateEntity.class);
        System.out.println("反序列化=" + obj);
    }
}
