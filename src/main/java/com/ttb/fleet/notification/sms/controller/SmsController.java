package com.ttb.fleet.notification.sms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.common.utils.StopWatch;
import com.ttb.fleet.notification.sms.dto.SmsIn;
import com.ttb.fleet.notification.sms.dto.SmsOut;
import com.ttb.fleet.notification.sms.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SmsController {
    private final Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Autowired
    private SmsService smsservice;

    @PostMapping("/v1/sms")
    public ResponseEntity<ResponseOut> SendSms(@RequestHeader Map<String, String> headers, @RequestBody(required = false) SmsIn body) {
        StopWatch watch = new StopWatch();
        ObjectMapper mapper = new ObjectMapper();
        logger.info(String.format("SendEmail Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));

        ApiStatusOut apistatus = new ApiStatusOut();
        ResponseOut response = new ResponseOut();
        HttpStatus httpStatus = null;
        try {
            // TODO: Implement Input Validation
            // TODO: Implement Business Logic

            if (body.getMobile() == null) {
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

            SmsOut smsOut = smsservice.send(headers.get("x-requested-id"), body.getMobile(), body.getMessageId(), body.getReplace(), body.getLanguage());
            if(smsOut.getStatus().equals("success")) {

                apistatus.setCode("S0000");
                apistatus.setBusinessMessage("SMS Sending Successful");
                apistatus.setDeveloperMessage("Success");

                String json = new Gson().toJson(smsOut);
                Map<String, Object> result = new ObjectMapper().readValue(json, HashMap.class);
                response.setData(result);
                httpStatus = HttpStatus.OK;
            } else {
                apistatus.setCode("E4004");
                apistatus.setBusinessMessage("SMS template not found");
                apistatus.setDeveloperMessage("Data not found");
                httpStatus = HttpStatus.NOT_FOUND;
            }
            response.setApiStatus(apistatus);
            return ResponseEntity.status(httpStatus).body(response);
        } catch (JsonProcessingException e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            response.setApiStatus(apistatus);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception e) {
            apistatus.setCode("E5000");
            apistatus.setBusinessMessage("Service Not Available");
            apistatus.setDeveloperMessage(e.getMessage());
            response.setApiStatus(apistatus);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } finally {
            try {
                logger.info(String.format("SendSms Controller Response: %s", mapper.writeValueAsString(response)));
                logger.info(String.format("SendSms Controller elapse time %.4f seconds", watch.elapsedTime()));
            } catch (JsonProcessingException e) {
                logger.error("Error during write log", e);
            }
        }
    }

    private String sendSmsSoapRequest() {
        return "";
    }
}
