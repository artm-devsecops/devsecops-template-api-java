FROM docker.io/eclipse-temurin:17-jre-ubi9-minimal
WORKDIR /app

COPY quebec.artm.concerto.api.poc-0.0.1-SNAPSHOT.jar app/app.jar

WORKDIR /app/build
ENTRYPOINT java -jar app.jar
