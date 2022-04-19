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
public class AppStarter{
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }
}
