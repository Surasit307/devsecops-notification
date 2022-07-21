package com.ttb.fleet.notification.email.service.impl;

import com.ttb.fleet.notification.common.utils.Template;
import com.ttb.fleet.notification.email.service.EmailService;
import com.ttb.fleet.notification.entity.Message;
import com.ttb.fleet.notification.entity.MessageLog;
import com.ttb.fleet.notification.logging.service.LoggingService;
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

    @Autowired
    private MessageRepository messagerepo;
    
    @Autowired
    private LoggingService loggingService;

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private static final SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    private Template template = new Template();

    @Override
    public EmailOut send(String requestedId,String[] to, int messageId, Map<String,String> replaceSubject, Map<String,String> replaceBody, String language) throws Exception {
        return send(requestedId, to, messageId, replaceSubject, replaceBody, language, null);
    }

    @Override
    public EmailOut send(String requestedId,String[] to, int messageId, Map<String,String> replaceSubject, Map<String,String> replaceBody, String language, Object attachment) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = messagerepo.findByMessageIdAndLanguage(messageId,language);
        EmailOut emailOut = new EmailOut();
        emailOut.setRequestedTimeStamp(simpledateformat.format(timestamp));

        if(message == null){
            emailOut.setStatus("message id Not Found");
        } else {
            emailOut.setStatus("success");
            String subject = template.stringTemplate(message.getSubject(), replaceSubject);
            String content = template.stringTemplate(message.getHtmlContent(), replaceBody);
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(mailMessage);
        }

        return emailOut;
    }
}
