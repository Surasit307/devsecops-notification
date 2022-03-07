package com.ttb.fleet.notification.sms.service.impl;

import com.ttb.fleet.notification.common.utils.Template;
import com.ttb.fleet.notification.entity.Message;
import com.ttb.fleet.notification.repository.MessageRepository;
import com.ttb.fleet.notification.sms.dto.SmsOut;
import com.ttb.fleet.notification.sms.service.SmsService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private MessageRepository messagerepo;

    private final Logger logger = LoggerFactory.getLogger(SmsService.class);
    private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private Template template = new Template();

    @Override
    public SmsOut send(String requestId,String[] mobiles, int msgid, Map<String, String> replace, String language) {
        logger.debug("Request:");
        // TODO: query message from MessageRepository
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = messagerepo.findByMessageIdAndLanguage(msgid,language);
        SmsOut smsout = new SmsOut();
        if(message == null){
            smsout.setStatus("message id Not Found");

            smsout.setRequestedTimeStamp(simpledateformat.format(timestamp));
        } else {
            smsout.setStatus("success");
            String subject = message.getSubject();
            String content = template.stringTemplate(message.getContent(), replace);
            for (String mobile:mobiles) {
                sendRequestToSmsGw("" + mobile, mobile, subject, content);
            }
        }

        return smsout;
    }

    private ResponseEntity<String> sendRequestToSmsGw(String recipientName, String smsNumber, String smsSubject, String smsContent) {
        StringBuilder urlStringBuilder = new StringBuilder("?");
        urlStringBuilder.append("Batch_No=").append(getBatchNo()).append("&");
        urlStringBuilder.append("Bank_Ref=").append(getBankRef()).append("&");
        urlStringBuilder.append("Product_code=").append("OTH-XXX").append("&");
        urlStringBuilder.append("SMS_Number=").append(smsNumber).append("&");
        urlStringBuilder.append("SMS_Subject=").append(smsSubject).append("&");
        urlStringBuilder.append("SMS_Content=").append(smsContent).append("&");
        urlStringBuilder.append("Sender_Info=").append("5432 - CBG E-Banking").append("&");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity( urlStringBuilder.toString(), String.class );
        return response;
    }

    private String getBatchNo(){
        return "2007110909010201";
    }

    private String getBankRef(){
        return "OTHXXX20071109090102";
    }

}
