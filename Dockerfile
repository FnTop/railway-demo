# 环境
FROM  williamyeh/java8:latest
# 作者信息
MAINTAINER david "3120338098@qq.com"
# 拷贝jar
ADD demo.jar /demo.jar
# 设置暴露的端口号
EXPOSE 80
# 执行命令
ENTRYPOINT ["java","-jar","/demo.jar"]
