#
# Build Stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY sonar-project.properties /home/app
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package Stage
#
FROM openjdk:11

# Set application's JAR file
ARG JAR_FILE=/home/app/target/*.jar

# Set volume point to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside container
EXPOSE 8081

# Add the application's JAR file to the container
COPY --from=build ${JAR_FILE} /application.jar

# Run the JAR file
# ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.config.location=file:///deployments/config/,file:///central/config/", "-jar", "/application.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "application.jar"]
