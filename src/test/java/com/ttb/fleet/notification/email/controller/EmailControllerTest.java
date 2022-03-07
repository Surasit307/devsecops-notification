package com.ttb.fleet.notification.email.controller;

import com.ttb.fleet.notification.common.dto.ResponseOut;
import com.ttb.fleet.notification.email.dto.EmailIn;
import com.ttb.fleet.notification.email.dto.EmailOut;
import com.ttb.fleet.notification.email.service.impl.emailServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest {
    private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    @InjectMocks
    private EmailController emailcontroller;
    @Mock
    private emailServiceImpl emailservice;

    @BeforeEach
    private void init() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        emailservice = mock(emailServiceImpl.class);

        EmailOut emailout = new EmailOut();
        emailout.setRequestedId("46e062f8-5c43-43b0-9734-019112ae1a62");
        emailout.setStatus("Success");
        emailout.setRequestedTimeStamp(simpledateformat.format(timestamp));
        try {
            lenient().when(emailservice.send(Mockito.anyString(), new String[]{Mockito.anyString()}, Mockito.anyInt(), Mockito.anyMap(), Mockito.anyMap(), Mockito.anyString())).thenReturn(emailout);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should be return S0000 when process success")
    void sendEmail() {
        Map<String, String> header = new HashMap<>();
        header.put("authorization", "UnVqamk=");
        header.put("x-authorizer", "implementhmac256");
        header.put("x-requested-id", "e0e30032-3936-4b11-b5d7-92b9aa3c9453");
        header.put("x-requested-timestamp", "2021-10-19T15:58:08+0700");
        header.put("x-journey", "register");
        header.put("x-api-key", "XXXXXXXXXXXXXXXXX");
        header.put("x-token", "XXXXXXXXXXXXXXXXX");
        header.put("x-system", "FE-fleet-customer");

        EmailIn emailin = new EmailIn();
        emailin.setMessageId(1);
        emailin.setLanguage("th");
        emailin.setTo(new String[]{"sender@example.com", "test@example.com"});

        ResponseEntity<ResponseOut> response = emailcontroller.SendEmail(header, emailin);
        Assertions.assertThat(response.getBody().getApiStatus().getCode()).isEqualTo("S0000");

    }

    @Test
    @DisplayName("Should be return E4001 when missing to parameter")
    void sendemailE4001() {
        Map<String, String> header = new HashMap<>();
        header.put("authorization", "UnVqamk=");
        header.put("x-authorizer", "implementhmac256");
        header.put("x-requested-id", "e0e30032-3936-4b11-b5d7-92b9aa3c9453");
        header.put("x-requested-timestamp", "2021-10-19T15:58:08+0700");
        header.put("x-journey", "register");
        header.put("x-api-key", "XXXXXXXXXXXXXXXXX");
        header.put("x-token", "XXXXXXXXXXXXXXXXX");
        header.put("x-system", "FE-fleet-customer");

        EmailIn emailin = new EmailIn();
        emailin.setMessageId(1);
        emailin.setLanguage("th");

        ResponseEntity<ResponseOut> response = emailcontroller.SendEmail(header, emailin);
        Assertions.assertThat(response.getBody().getApiStatus().getCode()).isEqualTo("E4001");
    }

    @Test
    @DisplayName("Should be return E4002 when missing to parameter")
    void sendemailE4002() {
        Map<String, String> header = new HashMap<>();
        header.put("authorization", "UnVqamk=");
        header.put("x-authorizer", "implementhmac256");
        header.put("x-requested-id", "e0e30032-3936-4b11-b5d7-92b9aa3c9453");
        header.put("x-requested-timestamp", "2021-10-19T15:58:08+0700");
        header.put("x-journey", "register");
        header.put("x-api-key", "XXXXXXXXXXXXXXXXX");
        header.put("x-token", "XXXXXXXXXXXXXXXXX");
        header.put("x-system", "FE-fleet-customer");

        EmailIn emailin = new EmailIn();
        emailin.setTo(new String[]{"sender@example.com", "test@example.com"});
        emailin.setLanguage("th");

        ResponseEntity<ResponseOut> response = emailcontroller.SendEmail(header, emailin);
        Assertions.assertThat(response.getBody().getApiStatus().getCode()).isEqualTo("E4002");
    }

    @Test
    @DisplayName("Should be return E4003 when missing language parameter")
    void sendemailE4003() {
        Map<String, String> header = new HashMap<>();
        header.put("authorization", "UnVqamk=");
        header.put("x-authorizer", "implementhmac256");
        header.put("x-requested-id", "e0e30032-3936-4b11-b5d7-92b9aa3c9453");
        header.put("x-requested-timestamp", "2021-10-19T15:58:08+0700");
        header.put("x-journey", "register");
        header.put("x-api-key", "XXXXXXXXXXXXXXXXX");
        header.put("x-token", "XXXXXXXXXXXXXXXXX");
        header.put("x-system", "FE-fleet-customer");

        EmailIn emailin = new EmailIn();
        emailin.setTo(new String[]{"sender@example.com", "test@example.com"});
        emailin.setMessageId(1);

        ResponseEntity<ResponseOut> response = emailcontroller.SendEmail(header, emailin);
        Assertions.assertThat(response.getBody().getApiStatus().getCode()).isEqualTo("E4003");
    }
}