package org.example.zfd;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.ModifierMatcher;
import net.bytebuddy.pool.TypePool;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2023/12/10 12:17 PM
 */
public class ByteBuddyTransformer implements ClassFileTransformer {

    /**
     * 在 某个类的字节码 被加载到JVM之前 都会先进入该方法. 如果对字节码进行修改则返回修改后的字节码, 否则直接返回null即可
     *
     * @param loader              the defining loader of the class to be transformed,
     *                            may be {@code null} if the bootstrap loader
     * @param className           the name of the class in the internal form of fully
     *                            qualified class and interface names as defined in
     *                            <i>The Java Virtual Machine Specification</i>.
     *                            For example, <code>"java/util/List"</code>.
     * @param classBeingRedefined if this is triggered by a redefine or retransform,
     *                            the class being redefined or retransformed;
     *                            if this is a class load, {@code null}
     * @param protectionDomain    the protection domain of the class being defined or redefined
     * @param classfileBuffer     the input byte buffer in class file format - must not be modified
     * @return a well-formed class file buffer (the result of the transform), or null if no transform is performed
     * @throws IllegalClassFormatException
     */
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] result = null;
        // 字节码中类名是使用/间隔, 而不是.
        if ("org/example/zfd/Something".equals(className)) {
            System.out.println("进行字节码修改， classname="+className);
            // 对Something.java进行字节码修改/增强 (这里修改字节码可以用任何字节码操作工具,
            // (asm, javassist, cglib, bytebuddy等)
            final String targetClassName = className.replace('/', '.');
            ClassFileLocator classFileLocator = ClassFileLocator.ForClassLoader.ofSystemLoader();
            ClassFileLocator.Compound compound = new ClassFileLocator.Compound(classFileLocator);
            TypePool typePool = TypePool.Default.of(compound);
            TypeDescription typeDescription = typePool.describe(targetClassName).resolve();
            DynamicType.Unloaded<Object> returnHello = new ByteBuddy()
                    .redefine(typeDescription, compound)
                    .method(ElementMatchers.named("returnHello")
                            .and(ModifierMatcher
                                    .of(ModifierMatcher.Mode.STATIC)))
                    .intercept(FixedValue.value("Hello, ByteBuddy!"))
//                    .name("org.example.zfd.Something2")
                    .make();
            try {
                returnHello.saveIn(DemoTools.currentClassPathFile());
                result = returnHello.getBytes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
