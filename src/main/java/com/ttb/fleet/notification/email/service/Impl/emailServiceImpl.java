package com.ttb.fleet.notification.email.service.Impl;

import com.ttb.fleet.notification.email.dto.EmailOut;
import com.ttb.fleet.notification.email.service.emailService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class emailServiceImpl implements emailService {

    @Override
    public EmailOut send(String[] to, String messageId, Map<String,String> replace, String language) {
        return null;
    }

    @Override
    public EmailOut send(String[] to, String subject,Map<String,String> replace, String content, Object attachment) {
        return null;
    }
}
