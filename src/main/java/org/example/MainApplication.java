package org.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@MapperScan("org.example.dao.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MainApplication.class);
        HashMap<String, Object> configMap = new HashMap<>();
//        configMap.put("server.port", 8999);
        springApplication.setDefaultProperties(configMap);
//        springApplication.setAdditionalProfiles("dev");
        springApplication.run(args);

    }
}
