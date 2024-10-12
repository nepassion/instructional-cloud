package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.HashMap;

@SpringBootApplication
@EnableOpenApi
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
