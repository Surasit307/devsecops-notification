package com.ttb.fleet.notification.sms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties
public class SmsIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("mobile")
    private String[] mobile;
    @JsonProperty("message_id")
    private String msgid;
    @JsonProperty("replace_value")
    private Map<String, String> replace;
    @JsonProperty("language")
    private String language;

    public String[] getMobile() {
        return mobile;
    }

    public void setMobile(String[] mobile) {
        this.mobile = mobile;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public Map<String, String> getReplace() {
        return replace;
    }

    public void setReplace(Map<String, String> replace) {
        this.replace = replace;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
