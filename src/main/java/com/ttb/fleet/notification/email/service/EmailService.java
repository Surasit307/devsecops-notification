package com.ttb.fleet.notification.email.service;

import com.ttb.fleet.notification.email.dto.EmailOut;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {

    public EmailOut send(String requestId, String[] to, int messageId,  Map<String,String> replaceSubject, Map<String,String> replaceBody, String language) throws Exception;

    public EmailOut send(String requestId, String[] to, int messageId,  Map<String,String> replaceSubject, Map<String,String> replaceBody, String language, Object attachment) throws Exception;
}
