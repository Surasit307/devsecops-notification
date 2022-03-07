package com.ttb.fleet.notification.email.service;

import com.ttb.fleet.notification.email.dto.EmailOut;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {

    public EmailOut send(String requestId, String[] to, int messageId, Map<String, String> replace, String language) throws MessagingException, IOException;

    public EmailOut send(String requestId, String[] to, int messageId, Map<String, String> replace, String language, Object attachment) throws MessagingException, IOException;
}
