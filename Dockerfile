# apply distroless image
FROM gcr.io/distroless/java11-debian11
WORKDIR /app
#COPY target/*.jar /app/app.jar
COPY build/libs/*.jar /app/app.jar
EXPOSE 8080

#ENTRYPOINT java ${JAVA_OPTS} -jar /app/app.jar
CMD ["/app/app.jar"]
