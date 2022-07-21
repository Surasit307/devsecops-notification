package com.ttb.fleet.notification.logging.service.impl;

import java.sql.Timestamp;
import java.util.Optional;

import com.ttb.fleet.notification.entity.MessageLog;
import com.ttb.fleet.notification.logging.service.LoggingService;
import com.ttb.fleet.notification.repository.MessageLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {
	
	@Autowired
	private MessageLogRepository messageLogRepository;
	
	
	 @Override
	public MessageLog createLog(String messageId,String subject,String content,String type,String receiver) {
		MessageLog log = new MessageLog();
		log.setMessageId(messageId);
		log.setMessage_subject(subject);
		log.setMessage_content(content);
		log.setMessage_type(type);
		log.setReceiver(receiver);
		log.setLog_datetime(new Timestamp(System.currentTimeMillis()));
		log.setStatus("Initial");
		log.setCreateOn(new Timestamp(System.currentTimeMillis()));
		log.setCreateBy("System");
		
		return messageLogRepository.save(log);
	}
	 
	 @Override
	public MessageLog updateLog(Integer logId,String status , String errorMsg) {
		Optional<MessageLog> updateLog = messageLogRepository.findById(logId);
		MessageLog log = updateLog.get();
		log.setStatus(status);
		log.setError_message(errorMsg);
		log.setUpdateBy("System");
		log.setUpdateOn(new Timestamp(System.currentTimeMillis()));
		
		return messageLogRepository.save(log);
		
	}

}
