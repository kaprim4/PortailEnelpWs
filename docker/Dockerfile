FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app

EXPOSE 8070
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
CMD ["./mvnw", "spring-boot:run"]
