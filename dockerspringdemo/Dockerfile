FROM openjdk:17
EXPOSE 8082
WORKDIR /app
COPY target/dockerspringdemo-0.0.1-SNAPSHOT.jar /app/simple.jar
ENTRYPOINT ["java", "-jar", "simple.jar"]