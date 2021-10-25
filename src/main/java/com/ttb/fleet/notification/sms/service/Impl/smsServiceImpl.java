package com.ttb.fleet.notification.sms.service.Impl;

import com.ttb.fleet.notification.entity.Message;
import com.ttb.fleet.notification.repository.messageRepository;
import com.ttb.fleet.notification.sms.controller.smsController;
import com.ttb.fleet.notification.sms.dto.SmsOut;
import com.ttb.fleet.notification.sms.service.smsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class smsServiceImpl implements smsService {
    private final Logger logger = LoggerFactory.getLogger(smsService.class);
    private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    @Autowired
    private messageRepository messagerepo;
    @Override
    public SmsOut send(String requestId,String[] mobile, String msgid, Map<String, String> replace, String language) {
        logger.debug("Request:");
        // TODO: query message from messageRepository
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message msg = messagerepo.findByMessageIdAndLanguage(msgid,language);
        SmsOut smsout = new SmsOut();
        if(msg == null){
            smsout.setStatus("message id Not Found");

            smsout.setRequestedTimeStamp(simpledateformat.format(timestamp));
        }
        // TODO: replace string format {} with replace variable
        return null;
    }
}
