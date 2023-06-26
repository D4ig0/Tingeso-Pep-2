FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} nutricional-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/nutricional-service-0.0.1-SNAPSHOT.jar"]
