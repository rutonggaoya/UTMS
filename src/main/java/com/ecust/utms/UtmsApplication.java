package com.ecust.utms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class UtmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtmsApplication.class, args);
    }

}