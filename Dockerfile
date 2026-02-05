# Stage 1: build with Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/workspace/target/*.jar
COPY --from=build ${JAR_FILE} /app/app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar /app/app.jar"]
