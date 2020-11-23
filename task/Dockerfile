FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]