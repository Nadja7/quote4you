FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8083
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} converting-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/converting-service.jar"]