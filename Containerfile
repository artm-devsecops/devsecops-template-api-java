FROM docker.io/eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY devsecops-template-api-java-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar app.jar
