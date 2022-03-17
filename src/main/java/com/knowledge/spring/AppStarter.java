package com.knowledge.spring;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knowledge.spring.json.LocalDateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/7 15:52
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan(value = "com.knowledge.spring.*")
public class AppStarter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }

    @Autowired
    ObjectMapper objectMapper;
    @Override
    public void run(String... args) throws JsonProcessingException {
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
