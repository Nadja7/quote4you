FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} quote-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/quote-service.jar"]