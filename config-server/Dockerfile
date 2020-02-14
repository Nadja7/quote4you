FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 88
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/config-service.jar"]