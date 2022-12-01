
FROM openjdk:8-jdk-alpine

# Set work directory
WORKDIR /app

# Copy application files
COPY target/*.jar app.jar

# Expose PORT
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]