package com.ttb.fleet.notification.email.service.impl;

import com.ttb.fleet.notification.common.utils.Template;
import com.ttb.fleet.notification.email.service.EmailService;
import com.ttb.fleet.notification.entity.EmailMessage;
import com.ttb.fleet.notification.entity.Message;
import com.ttb.fleet.notification.entity.MessageLog;
import com.ttb.fleet.notification.logging.service.LoggingService;
import com.ttb.fleet.notification.repository.EmailMessageRepository;
import com.ttb.fleet.notification.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ttb.fleet.notification.email.dto.EmailOut;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class emailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	
	 @Autowired private EmailMessageRepository emailMsgRepo;
	 

	private final Logger logger = LoggerFactory.getLogger(EmailService.class);
	private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
	private Template template = new Template();

	@Override
	public EmailOut send(String requestedId, String[] to, String messageIdTh,String messageIdEn, Map<String, String> replaceSubject,Map<String, String> replaceBody) throws Exception {
		return send(requestedId, to, messageIdTh,messageIdEn, replaceSubject, replaceBody, null);
	}

	@Override
	public EmailOut send(String requestedId, String[] to, String messageIdTh,String messageIdEn, Map<String, String> replaceSubject,Map<String, String> replaceBody, Object attachment) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		EmailMessage messageTh = getMessage(messageIdTh,"TH");
		EmailMessage messageEn = getMessage(messageIdEn,"EN");
		EmailOut emailOut = new EmailOut();
		emailOut.setRequestedTimeStamp(simpledateformat.format(timestamp));
		emailOut.setStatus("success");
		String subject = template.stringTemplate(template.combineMessageContent(messageTh, messageEn, "subject"), replaceSubject);
		String content = template.stringTemplate(template.combineMessageContent(messageTh, messageEn, "content"), replaceBody);
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(content, true);
		javaMailSender.send(mailMessage);

		return emailOut;
	}


	public EmailMessage getMessage(String messageId, String language) {
		return emailMsgRepo.findByMessageIdAndLanguage(messageId,language);
	}

}
