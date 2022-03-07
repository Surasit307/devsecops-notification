package com.ttb.fleet.notification.email.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.common.utils.StopWatch;
import com.ttb.fleet.notification.common.utils.Template;
import com.ttb.fleet.notification.email.dto.EmailIn;
import com.ttb.fleet.notification.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailservice;

    private final Logger logger = LoggerFactory.getLogger(EmailController.class);
    private Template template = new Template();

    @PostMapping("/v1/email")
    public ResponseEntity<ResponseOut> SendEmail(@RequestHeader Map<String, String> headers, @RequestBody(required = false) EmailIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("SendEmail Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        try {
            if (body.getTo() == null) {
                apistatus.setCode("E4001");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter to is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getMessageId() == 0) {
                apistatus.setCode("E4002");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter message_id is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (body.getLanguage() == null) {
                apistatus.setCode("E4003");
                apistatus.setBusinessMessage("Require field missing");
                apistatus.setDeveloperMessage("parameter language is missing");
                response.setApiStatus(apistatus);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            // TODO: Implement Business Logic
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Email Sending Successful");
            apistatus.setDeveloperMessage("Success");
            response.setApiStatus(apistatus);
            response.setData((Map<String, Object>) emailservice.send(headers.get("x-requested-id"), body.getTo(), body.getMessageId(), body.getReplaceString(), body.getLanguage()));
            logger.info(String.format("SendEmail Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("SendEmail Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (JsonProcessingException e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (MessagingException | IOException e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Incorrect mail format");
            apistatus.setDeveloperMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
