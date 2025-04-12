package org.example.zfd;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.This;

import java.util.Arrays;

/**
 * 对拦截的构造方法进行增强
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2023/12/15 11:28 PM
 */
public class ConstructorInterceptor {
    @RuntimeType
    public void constructorIntercept(@Origin Class<?> clazz,
                                     @This Object targetObj,
                                     @AllArguments Object[] targetMethodArgs) {
        System.out.println(
                "clazz=" + clazz.getName() +
                        ", targetObj: " + targetObj +
                        ", args: " + Arrays.toString(targetMethodArgs));
    }
}
