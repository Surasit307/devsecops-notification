package com.ttb.fleet.notification.email.service;

import com.ttb.fleet.notification.email.dto.EmailOut;

import java.util.Map;

public interface emailService {

    public EmailOut send(String[] to, String messageId, Map<String, String> replace, String language);

    public EmailOut send(String[] to, String messageId, Map<String, String> replace, String language, Object attachment);
}
