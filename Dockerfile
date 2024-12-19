FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy dependencies
COPY target/demo-auth-0.0.1-SNAPSHOT.jar demo-auth-0.0.1-SNAPSHOT.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "demo-auth-0.0.1-SNAPSHOT.jar"]