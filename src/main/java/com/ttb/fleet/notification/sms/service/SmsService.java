package com.ttb.fleet.notification.sms.service;

import com.ttb.fleet.notification.sms.dto.SmsOut;

import java.util.Map;

public interface SmsService {

    public SmsOut send(String requestId, String[] mobile, String msgid, Map<String, String> replace, String language);
}
