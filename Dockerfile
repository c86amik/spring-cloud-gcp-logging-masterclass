# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/spring-cloud-gcp-logging-masterclass-0.1.jar spring-cloud-gcp-logging-masterclass-0.1.jar

# Expose the port your application listens on
EXPOSE 7123

# Define the command to run your application
CMD ["java", "-jar", "spring-cloud-gcp-logging-masterclass-0.1.jar"]