
# Use Maven and Java 17
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build project and run tests
RUN mvn clean package

# Use Java 17 runtime
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy generated JAR
COPY --from=build /app/target/ParkingFeeCalculator-1.0-SNAPSHOT.jar app.jar

# Run application
CMD ["java", "-jar", "app.jar"]
