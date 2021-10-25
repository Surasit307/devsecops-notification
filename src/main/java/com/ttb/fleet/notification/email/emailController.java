package com.ttb.fleet.notification.email;

import com.ttb.fleet.notification.common.dto.ApiStatusOut;
import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.email.dto.EmailIn;
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
    public ResponseEntity<ResponseOut> SendEmail(@RequestHeader Map<String, String> headers,@RequestBody EmailIn body){

        logger.info(String.format("generateOTP Controller Request Header: %s", headers.keySet().stream()
                .map(key -> key + ":" + headers.get(key))
                .collect(Collectors.joining(", ", "{", "}"))));
//        logger.info(String.format("generateOTP Controller Request Body: %s", body.keySet().stream()
//                .map(key -> key + ":" + body.get(key))
//                .collect(Collectors.joining(", ", "{", "}"))));

        ApiStatusOut apistatus = new ApiStatusOut();
        apistatus.setCode("E5000");
        apistatus.setBusinessMessage("Service Not Available");
        apistatus.setDeveloperMessage("Service under constructor");
        ResponseOut response = new ResponseOut();
        response.setApiStatus(apistatus);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }
}
