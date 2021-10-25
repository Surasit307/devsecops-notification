package com.ttb.fleet.notification.email.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.common.utils.StopWatch;
import com.ttb.fleet.notification.email.dto.EmailIn;
import com.ttb.fleet.notification.email.service.emailService;
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
public class emailController {

    private final Logger logger = LoggerFactory.getLogger(emailController.class);

    @Autowired
    private emailService emailservice;

    @PostMapping("/v1/email")
    public ResponseEntity<ResponseOut> SendEmail(@RequestHeader Map<String, String> headers,@RequestBody EmailIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("SendEmail Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
//        logger.info(String.format("generateOTP Controller Request Body: %s", body.keySet().stream()
//                .map(key -> key + ":" + body.get(key))
//                .collect(Collectors.joining(", ", "{", "}"))));
        try {
            // TODO: Implement Input Validation
            // TODO: Implement Business Logic
            ApiStatusOut apistatus = new ApiStatusOut();
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Email Sending Successful");
            apistatus.setDeveloperMessage("Success");
            ResponseOut response = new ResponseOut();
            response.setApiStatus(apistatus);
            logger.info(String.format("SendEmail Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("SendEmail Controller elapse time %.4f seconds",watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (JsonProcessingException e) {
            ApiStatusOut apistatus = new ApiStatusOut();
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            ResponseOut response = new ResponseOut();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
