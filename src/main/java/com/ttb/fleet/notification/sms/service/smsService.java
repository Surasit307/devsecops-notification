package com.ttb.fleet.notification.sms.service;

import com.ttb.fleet.notification.sms.dto.SmsOut;

import java.util.Map;

public interface smsService {

    public SmsOut send(String[] mobile, String msgid, Map<String,String> replace, String language);
}
