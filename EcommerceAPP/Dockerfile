# Stage 1: build the jar with the Maven wrapper
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Download dependencies first so Docker caches them between builds
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw -B dependency:go-offline

COPY src src
# The only test starts the whole app and needs a live database, which the build doesn't have
RUN ./mvnw -B package -DskipTests

# Stage 2: run it on a smaller Java runtime image
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
# Render passes the port in $PORT; fall back to 8080 when running locally
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
