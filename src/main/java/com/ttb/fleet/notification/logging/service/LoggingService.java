package com.ttb.fleet.notification.logging.service;

import com.ttb.fleet.notification.entity.MessageLog;

public interface LoggingService {

	public MessageLog createLog(String messageId,String subject,String content,String type,String receiver);
	public MessageLog updateLog(Integer logId,String status , String errorMsg);
}
