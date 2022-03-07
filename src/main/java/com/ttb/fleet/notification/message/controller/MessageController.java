package com.ttb.fleet.notification.message.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.common.utils.StopWatch;
import com.ttb.fleet.notification.email.dto.EmailIn;
import com.ttb.fleet.notification.message.dto.RequestIn;
import com.ttb.fleet.notification.message.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private final Logger logger = LoggerFactory.getLogger(com.ttb.fleet.notification.email.controller.EmailController.class);

    @PostMapping("/v1/message")
    public ResponseEntity<ResponseOut> createMessage(@RequestHeader Map<String, String> headers, @RequestBody(required = false) RequestIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("CreateMessage Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        try {
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Create Data Successful");
            apistatus.setDeveloperMessage("Success");
            response.setApiStatus(apistatus);
            response.setData((Map<String, Object>) messageService.create(body));
            logger.info(String.format("CreateMessage Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("CreateMessage Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/v1/message/{messageId}/{language}")
    public ResponseEntity<ResponseOut> readMessage(@RequestHeader Map<String, String> headers, @PathVariable int messageId, @PathVariable String language) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("ReadMessage Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        try {
            Map data = (Map<String, Object>)  messageService.read(messageId, language);
            if(data == null){
                apistatus.setCode("E404");
                apistatus.setBusinessMessage("Data not found");
                apistatus.setDeveloperMessage("Data not found");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Query Data Successful");
            apistatus.setDeveloperMessage("Success");
            response.setApiStatus(apistatus);
            response.setData(data);
            logger.info(String.format("ReadMessage Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("ReadMessage Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/v1/message")
    public ResponseEntity<ResponseOut> updateMessage(@RequestHeader Map<String, String> headers, @RequestBody(required = false) RequestIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("UpdateMessage Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        try {
            Map data = (Map<String, Object>) messageService.update(body);
            if(data == null){
                apistatus.setCode("E404");
                apistatus.setBusinessMessage("Data not found");
                apistatus.setDeveloperMessage("Data not found");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Update Data Successful");
            apistatus.setDeveloperMessage("Success");
            response.setApiStatus(apistatus);
            response.setData(data);
            logger.info(String.format("UpdateMessage Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("UpdateMessage Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/v1/message/{messageId}/{language}")
    public ResponseEntity<ResponseOut> deleteMessage(@RequestHeader Map<String, String> headers, @PathVariable int messageId, @PathVariable String language) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("DeleteMessage Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        try {
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Delete Data Successful");
            apistatus.setDeveloperMessage("Success");
            response.setApiStatus(apistatus);
            response.setData((Map<String, Object>) messageService.delete(messageId, language));
            logger.info(String.format("DeleteMessage Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("DeleteMessage Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
