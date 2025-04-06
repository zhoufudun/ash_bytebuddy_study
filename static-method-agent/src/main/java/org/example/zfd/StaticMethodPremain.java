package org.example.zfd;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import org.example.StaticTransformer;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * premain 入口, 进行java agent 插桩
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2023/12/15 9:56 PM
 */
public class StaticMethodPremain {

    /**
     * java agent 入口, premain 在main方法之前执行
     */
    public static void premain(String arg, Instrumentation instrumentation) {
        System.out.println("执行 premain");
        new AgentBuilder.Default()
                // 使用我们自定义的匹配器指定拦截的类
                .type(named("org.example.zfd.StaticUtils"))
                .transform(new StaticTransformer())
                .installOn(instrumentation);
    }
}
