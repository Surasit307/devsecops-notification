package com.ttb.fleet.notification.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties
public class EmailIn  implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("to")
    private String[] to;
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("langiage")
    private String language;
    @JsonProperty("object")
    private Map<String,String> replaceString;

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public Map<String, String> getReplaceString() {
        return replaceString;
    }

    public void setReplaceString(Map<String, String> replaceString) {
        this.replaceString = replaceString;
    }
}
