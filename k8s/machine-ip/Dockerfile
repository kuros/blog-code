FROM openjdk:8-jdk-alpine
COPY target/machine-ip-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]