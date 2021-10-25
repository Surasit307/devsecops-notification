FROM openjdk:11

# Set volume point to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside container
EXPOSE 8081

# Set application's JAR file
ARG JAR_FILE=./target/*.jar

# Add the application's JAR file to the container
COPY ${JAR_FILE} /application.jar

# Run the JAR file
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.config.location=file:///deployments/config/,file:///central/config/", "-jar", "/application.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "application.jar"]
