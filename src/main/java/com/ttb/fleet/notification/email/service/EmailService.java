package com.ttb.fleet.notification.email.service;

import com.ttb.fleet.notification.email.dto.EmailOut;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {

	public EmailOut send(String requestedId, String[] to, String messageIdTh,String messageIdEn, Map<String, String> replaceSubject,Map<String, String> replaceBody) throws Exception;
	public EmailOut send(String requestedId, String[] to, String messageIdTh,String messageIdEn, Map<String, String> replaceSubject,Map<String, String> replaceBody, Object attachment) throws Exception;

}
