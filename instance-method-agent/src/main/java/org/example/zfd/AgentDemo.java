package org.example.zfd;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.isAnnotatedWith;
import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * 实现拦截springmvc的controller方法
 */
public class AgentDemo {
    private static final String CONTROLLER_NAME = "org.springframework.stereotype.Controller";
    private static final String REST_CONTROLLER_NAME = "org.springframework.web.bind.annotation.RestController";
    /**
     * java agent 入口, premain在main方法之前执行
     */
    public static void premain(String arg, Instrumentation instrumentation) {
        System.out.println("执行 main, args = " + arg);
        AgentBuilder agentBuilder = new AgentBuilder.Default()
                // 忽略(不拦截)的类, 这里忽略 java自带类和byte buddy的类
                .ignore(ElementMatchers.nameStartsWith("java.")
                        .or(ElementMatchers.nameStartsWith("javax."))
                        .or(ElementMatchers.nameStartsWith("jdk."))
                        .or(ElementMatchers.nameStartsWith("sun."))
                        // 忽略byte buddy的类
                        .or(ElementMatchers.nameStartsWith("net.bytebuddy.")))
                // 配置哪些类需要拦截
                .type(isAnnotatedWith(named(CONTROLLER_NAME))
                        .or(isAnnotatedWith(named(REST_CONTROLLER_NAME))))
                .transform(new AgentTransform())
                // 注册 回调方法监听器
                .with(new ByteBuddyListener());

        // 注册到Instrumentation
        agentBuilder.installOn(instrumentation);
    }
}
