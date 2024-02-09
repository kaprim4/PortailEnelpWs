FROM alpine

RUN addgroup -S nonroot \
    && adduser -S nonroot -G nonroot

USER nonroot

FROM eclipse-temurin:17-jdk-focal

EXPOSE 8070

ENV APP_HOME /usr/src/app

COPY target/PortailEnelpWs-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar app.jar
