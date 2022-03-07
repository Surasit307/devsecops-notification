package com.ttb.fleet.notification.sms.service;

import com.ttb.fleet.notification.sms.dto.SmsOut;

import java.util.Map;

public interface SmsService {

    public SmsOut send(String requestId, String[] mobile, int msgid, Map<String, String> replace, String language) throws Exception;
}
