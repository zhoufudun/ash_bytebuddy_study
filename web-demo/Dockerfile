FROM openjdk:8-jdk-alpine
MAINTAINER zhoufudun
ADD ./target/webdemo-0.0.1-SNAPSHOT.jar webdemo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/webdemo.jar"]

# https://juejin.cn/post/6950952084606812174
# 宿主机文件夹/root/arthas/挂载到docker中的/arthas目录下
# 宿主机中执行：docker run -P -v /root/arthas/:/arthas --name web-demo -d web-demo:latest