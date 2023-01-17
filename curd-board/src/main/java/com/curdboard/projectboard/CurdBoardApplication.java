package com.curdboard.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CurdBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurdBoardApplication.class, args);
    }
}
