package com.example.webdemo.conterller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/nacos")
public class NacosController {

    @Autowired
    Environment environment;

    @Value("${nacos.username:nacos}")
    String username;

    @Value("${nacos.password:ihuman123!@#}")
    String password;

    @RequestMapping("getAllInstances")
    public void getAllInstances() {

        environment.getProperty("nacos.username");
    }
}
