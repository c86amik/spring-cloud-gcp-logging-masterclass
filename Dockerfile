# Use the official OpenJDK base image
FROM openjdk:11-jre-slim
VOLUME tmp
# Copy the JAR file into the container
ADD target/*.jar spring-cloud-gcp-logging-masterclass-0.1.jar

# Expose the port your application listens on
EXPOSE 7124
ENV JAVA_OPTS=""
# Define the command to run your application
ENTRYPOINT [ "sh" "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /spring-cloud-gcp-logging-masterclass-0.1.jar" ]