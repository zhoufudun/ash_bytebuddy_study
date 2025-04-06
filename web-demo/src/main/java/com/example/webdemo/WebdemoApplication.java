package com.example.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -javaagent:D:\study\Desktop\Desktop\study\ash_bytebuddy_study\instance-method-agent\target\instance-method-agent-1.0-SNAPSHOT-jar-with-dependencies.jar
 */
@SpringBootApplication
public class WebdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdemoApplication.class, args);
    }

}
