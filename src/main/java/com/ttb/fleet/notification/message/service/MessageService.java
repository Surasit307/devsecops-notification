package com.ttb.fleet.notification.message.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttb.fleet.notification.message.dto.RequestIn;

import java.util.Map;

public interface MessageService {
    Map<String,Object> create(RequestIn requestIn) throws JsonProcessingException;

    Map<String,Object> read(int messageId, String language) throws JsonProcessingException;

    Map<String,Object> update(RequestIn requestIn) throws JsonProcessingException;

    Map<String,Object> delete(int messageId, String language) throws JsonProcessingException;
}
