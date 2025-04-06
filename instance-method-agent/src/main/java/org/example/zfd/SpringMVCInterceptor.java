package org.example.zfd;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * 实例方法 拦截器
 * 输出被调用的方法的方法名, 参数, 返回值, 执行时间
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2023/12/10 8:30 PM
 */
public class SpringMVCInterceptor {

    @RuntimeType
    public Object instanceMethodIntercept(
            @This Object targetObject,
            @Origin Method targetMethod,
            @AllArguments Object[] targetMethodArgs,
            @SuperCall Callable<?> zuper) {
        System.out.println("targetObject=" + targetObject);
        System.out.println("「增强逻辑」targetMethod.getName() = " + targetMethod.getName());
        System.out.println("「增强逻辑」Arrays.toString(targetMethodArgs) = " + Arrays.toString(targetMethodArgs));
        long callStartTime = System.currentTimeMillis();
        Object returnValue = null;
        try {
            returnValue = zuper.call();
            System.out.println("「增强逻辑」returnValue = " + returnValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("「增强逻辑」callTime: " + (System.currentTimeMillis() - callStartTime));
        }
        return returnValue;
    }
}
