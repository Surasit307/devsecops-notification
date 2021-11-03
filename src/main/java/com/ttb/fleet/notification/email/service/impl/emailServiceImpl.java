package com.ttb.fleet.notification.email.service.impl;

import com.ttb.fleet.notification.email.dto.EmailOut;
import com.ttb.fleet.notification.email.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class emailServiceImpl implements EmailService {

    @Override
    public EmailOut send(String requestedId,String[] to, String messageId, Map<String,String> replace, String language) {
        return null;
    }

    @Override
    public EmailOut send(String requestedId,String[] to, String subject,Map<String,String> replace, String content, Object attachment) {
        return null;
    }
}
