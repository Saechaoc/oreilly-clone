package com.chris.oreillyclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class OreillyCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OreillyCloneApplication.class, args);
    }

}
