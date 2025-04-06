package org.example.zfd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 简单的创建4个线程, 打印 {@link org.example.Something#returnHello()} 的返回值
 * java -javaagent:D:\study\Desktop\Desktop\study\ash_bytebuddy_study\jdk-agent\target\jdk-agent-1.0-SNAPSHOT-jar-with-dependencies.jar=k1=1,k2=2
 * k1=1,k2=2表示传递参数
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2023/12/10 12:02 PM
 */
public class MainClass {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int count = 0; count < 4; ++count) {
            executorService.submit(() -> {
                for (int i = 10; i > 0; --i) {
//                    System.out.println(Thread.currentThread().getName() + ", Something.returnHello(): " + Something.returnHello());
                    try {
                        Thread.sleep(5000);
                        System.out.println(Something.returnHello());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
