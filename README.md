# Notification Module
## Description
## Running Instructure
   - To running unit test of project
   mvn clean test
   - To packaging project into jar file.
   mvn clean package
   - To Start Service in local environment
   ./mvnw spring-boot:run
   - build docker image with tag notification:latest
   docker build . -t notification:latest
   - running container in local environment.
   docker run -p 8081:8081 notification:latest
   
## Entity

## Repository

## Functionality
### sms
#### Propose

#### Process

#### REST API

### email
#### Propose

#### Process

#### REST API