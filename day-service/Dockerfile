FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8085
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} day-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/day-service.jar"]