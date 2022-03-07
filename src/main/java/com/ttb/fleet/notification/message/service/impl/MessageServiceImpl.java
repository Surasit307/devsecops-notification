package com.ttb.fleet.notification.message.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ttb.fleet.notification.entity.Message;
import com.ttb.fleet.notification.message.dto.RequestIn;
import com.ttb.fleet.notification.message.service.MessageService;
import com.ttb.fleet.notification.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messagerepo;

    @Override
    public Map<String,Object> create(RequestIn requestIn) throws JsonProcessingException {
        Message message = new Message();
        message.setSubject(requestIn.getSubject());
        message.setContent(requestIn.getContent());
        message.setHtmlContent(requestIn.getHtmlContent());
        message.setLanguage(requestIn.getLanguage());
        message.setCreateBy("Tanasin");
        message.setCreateOn(new Timestamp(System.currentTimeMillis()));
        message.setStatus("Active");

        messagerepo.save(message);
        String json = new Gson().toJson(message);
        System.out.println(json);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }

    @Override
    public Map<String,Object> read(int messageId, String language) throws JsonProcessingException {
        Message message = messagerepo.findByMessageIdAndLanguage(messageId, language);
        String json = new Gson().toJson(message);
        System.out.println(json);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }

    @Override
    public Map<String,Object> update(RequestIn requestIn) throws JsonProcessingException {
        Message message = messagerepo.findByMessageIdAndLanguage(requestIn.getMessageId(), requestIn.getLanguage());
        if(message == null){
            return null;
        }
        message.setMessageId(requestIn.getMessageId());
        message.setSubject(requestIn.getSubject());
        message.setContent(requestIn.getContent());
        message.setLanguage(requestIn.getLanguage());
        message.setUpdateBy("Tanasin");
        message.setUpdateOn(new Timestamp(System.currentTimeMillis()));
        message.setStatus("Active");

        message = messagerepo.save(message);
        String json = new Gson().toJson(message);
        System.out.println(json);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }

    @Override
    public Map<String,Object> delete(int messageId, String language) throws JsonProcessingException {
        Message message = messagerepo.findByMessageIdAndLanguage(messageId, language);
        messagerepo.delete(message);
        String json = new Gson().toJson(message);
        System.out.println(json);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }
}
