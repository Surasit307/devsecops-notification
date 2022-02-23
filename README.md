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

message

history

## Repository

MessageRepository with CRUD API

## Functionality
### sms
#### Propose

​	Provide channel to interface SMS Gateway

#### Process

```
Validation input
	if fail return "E4001"
Query Message from Database with specific language
	if query fail return "E5001"
Replace Message wording with parameter input
	if replace fail return "E5002"
call SOAP API http://172.20.5.x:80/smsgw/smshttphandler_enc.ashx
with 
	Product_code : OTHNFC     
	Sender_Info : 8139
	if call API fail return "E5003"
	
if fail necessary handle return "E5000"

```



#### REST API

```
HTTPMethod: POST
Path: /services/notification/api/v1/sms
Request:
	Header:
		"authorized": "", 
		"x-authorizer": "",
		"x-requested-id": "",
		"x-requested-timestamp": "",
		"x-journey": ""
		"x-lanaguage": ""

	Body:
		message_id: ""
		from: ""
		replace_value: JSONObject ex. { "ref": "", "otpvalue": "" }
		mobile_no: String Array ex ["088XXXXXXX", "088XXXYYYY"]
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

​	Provide channel to interface Email server 

#### Process

```
Validation input
	if fail return "E4001"
Query Message from Database with specific language
	if query fail return "E5001"
Replace Message wording with parameter input
	if replace fail return "E5002"
communicate with SMTP Server 
	for dev: communicate to IP: 172.25.8.39  PORT: 25 without username, password  (please use application.yml for setup)
    for prod: communicate to IP: XXXXXX PORT: 587 with username/password
	if fail return "E5003"
	
if fail necessary handle return "E5000"
```



#### REST API

```
HTTPMethod: POST
Path: /services/notification/api/v1/email
Request:
	Header:
		"authorized": "", 
		"x-authorizer": "",
		"x-requested-id": "",
		"x-requested-timestamp": "",
		"x-journey": ""
		"x-lanaguage": ""
	Body: 
		message_id: ""
		from: "",
		to: ["test@example.com", "noreply@example.com"],
		cc: ["optional"],
		bcc: ["optional"],
		replace_subject: JSONObject ex { "str1", "MR. Firstname"}
		replace_body: JSONObject ex { "amount", "1,000.00"}
	
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

