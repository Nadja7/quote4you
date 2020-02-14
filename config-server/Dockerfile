FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8888
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/config-server.jar"]