FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8761
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} discovery-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/discovery-service.jar"]