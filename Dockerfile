# apply distroless image
FROM gcr.io/distroless/java11-debian11
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080

CMD ["/app/app.jar"]
