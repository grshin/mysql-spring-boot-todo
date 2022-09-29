FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080

ENTRYPOINT exec java ${JAVA_OPTS} -jar /app/app.jar
