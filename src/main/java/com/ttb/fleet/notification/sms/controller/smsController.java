package com.ttb.fleet.notification.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.common.utils.StopWatch;
import com.ttb.fleet.notification.sms.dto.SmsIn;
import com.ttb.fleet.notification.sms.service.smsService;
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
public class smsController {
    private final Logger logger = LoggerFactory.getLogger(smsController.class);

    @Autowired
    private smsService smsservice;

    @PostMapping("/v1/sms")
    public ResponseEntity<ResponseOut> SendSms(@RequestHeader Map<String, String> headers, @RequestBody(required = false) SmsIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("SendEmail Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));

        try {
            // TODO: Implement Input Validation
            // TODO: Implement Business Logic
            ApiStatusOut apistatus = new ApiStatusOut();
            apistatus.setCode("S0000");
            apistatus.setBusinessMessage("Email Sending Successful");
            apistatus.setDeveloperMessage("Success");
            ResponseOut response = new ResponseOut();
            response.setApiStatus(apistatus);
            response.setData((Map<String, Object>) smsservice.send(headers.get("x-requested-id"), body.getMobile(), body.getMsgid(), body.getReplace(), body.getLanguage()));
            logger.info(String.format("SendEmail Controller Response: %s", mapper.writeValueAsString(response)));
            logger.info(String.format("SendEmail Controller elapse time %.4f seconds", watch.elapsedTime()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (JsonProcessingException e) {
            ApiStatusOut apistatus = new ApiStatusOut();
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            ResponseOut response = new ResponseOut();
            response.setApiStatus(apistatus);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
