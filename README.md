# Notification Module
## Description
## Running Instruction
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

## Swagger
    https://{endpoint}/services/{modules}/api/swagger/api-docs
## Entity

## Repository

## Functionality
### sms
#### Propose

#### Process

#### REST API

```
HTTPMethod: POST
Path: /services/notification/api/v1/sms
Request:
	Header:
	
	Body:
	
Response:
	{
		api_status: {
			api_code: "S0000",
			api_business_message: "",
			api_developer_message: ""
		},
		data: {
		
		}
	}
```



### email
#### Propose

#### Process

#### REST API

```
HTTPMethod: POST
Path: /services/notification/api/v1/email
Request:
	Header:
	
	Body: {
	
	}
	
Response:
	{
		api_status: {
			api_code: "S0000",
			api_business_message: "",
			api_developer_message: ""
		},
		data: {
		
		}
	}
```

