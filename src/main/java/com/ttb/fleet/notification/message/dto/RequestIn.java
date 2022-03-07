package com.ttb.fleet.notification.message.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class RequestIn implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("message_id")
    private int messageId;
    @JsonProperty("language")
    private String language;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("content")
    private String content;
    @JsonProperty("html_content")
    private String html_content;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return html_content;
    }

    public void setHtmlContent(String html_content) {
        this.html_content = html_content;
    }
}
