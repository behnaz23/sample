FROM openjdk:11-jre-slim
ADD target/greeting-service-1.0-SNAPSHOT.jar /usr/local/
WORKDIR /usr/local/
ENTRYPOINT ["java", "-jar", "greeting-service-1.0-SNAPSHOT.jar"]
