# Build stage
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
# Copy the pom.xml and download dependencies first (caching layer)
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the rest of the source code and package the application
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Render assigns the PORT environment variable dynamically
EXPOSE ${PORT:-8085}

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
