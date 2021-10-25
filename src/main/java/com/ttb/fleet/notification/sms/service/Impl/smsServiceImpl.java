package com.ttb.fleet.notification.sms.service.Impl;

import com.ttb.fleet.notification.sms.dto.SmsOut;
import com.ttb.fleet.notification.sms.service.smsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class smsServiceImpl implements smsService {
    @Override
    public SmsOut send(String[] mobile, String msgid, Map<String, String> replace, String language) {
        // TODO: query message from messageRepository

        // TODO: replace string format {} with replace variable
        return null;
    }
}
