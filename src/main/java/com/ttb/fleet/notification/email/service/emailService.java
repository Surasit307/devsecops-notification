package com.ttb.fleet.notification.email.service;

import com.ttb.fleet.notification.email.dto.EmailOut;

public interface emailService {

    public EmailOut send(String[] to, String subject, String content);
    public EmailOut send(String[] to, String subject,String content,Object attachment);
}
