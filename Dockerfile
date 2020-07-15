FROM openjdk:8-jdk-alpine as build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B
COPY src src
RUN ./mvnw package -DskipTests
ARG JAR_FILE=/app/target/*.jar
RUN cp ${JAR_FILE} application.jar

FROM openjdk:8-jre-alpine as production
COPY --from=build /app/application.jar member.jar
ENTRYPOINT ["java", "-jar", "member.jar"]



