# 环境
FROM  williamyeh/java8:latest
# 作者信息
MAINTAINER david "3120338098@qq.com"
# 将本地文件tmp挂载到容器
WORKDIR /app
# 拷贝jar
ADD demo.jar /demo.jar
# 设置暴露的端口号
EXPOSE 80
# 执行命令
ENTRYPOINT ["java","-jar","/demo.jar"]
