FROM openjdk:8-jdk-alpine as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B
COPY src src
RUN ./mvnw package -DskipTests

FROM openjdk:8-jre-alpine as production
COPY --from=build /app/target/members-0.0.1-SNAPSHOT.jar /app/members.jar
ENTRYPOINT ["java", "-jar", "/app/members.jar"]



