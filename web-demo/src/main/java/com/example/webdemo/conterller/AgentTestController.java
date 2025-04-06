package com.example.webdemo.conterller;

import com.example.webdemo.service.PrintUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test/agent")
public class AgentTestController {

    @RequestMapping("enhancer")
    public String enhancer() {
        new PrintUtil().print("enhancer test");
        return "enhancer";
    }
}
