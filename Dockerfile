FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080

ARG MYSQL_URL=jdbc:mysql://localhost:3306/tododb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
ARG MYSQL_USERNAME=todouser
ARG MYSQL_PASSWORD=todopassword

ENV MYSQL_URL=${MYSQL_URL}
ENV MYSQL_USERNAME=${MYSQL_USERNAME}
ENV MYSQL_PASSWORD=${MYSQL_PASSWORD}

ENTRYPOINT exec java ${JAVA_OPTS} -jar /app/app.jar
