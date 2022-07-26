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
    @JsonProperty("message_id_th")
    private String messageIdTh;
    @JsonProperty("message_id_en")
    private String messageIdEn;
    @JsonProperty("language")
    private String language;
    @JsonProperty("replace_subject")
    private Map<String,String> replaceSubject;
    @JsonProperty("replace_body")
    private Map<String,String> replaceBody;

    public String[] getTo() {
        return to;
    }
    public void setTo(String[] to) {
        this.to = to;
    }

    public String getMessageIdTh() {
		return messageIdTh;
	}
	public void setMessageIdTh(String messageIdTh) {
		this.messageIdTh = messageIdTh;
	}
	public String getMessageIdEn() {
		return messageIdEn;
	}
	public void setMessageIdEn(String messageIdEn) {
		this.messageIdEn = messageIdEn;
	}
	public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, String> getReplaceSubject() {
        return replaceSubject;
    }
    public void setReplaceSubject(Map<String, String> replaceSubject) {
        this.replaceSubject = replaceSubject;
    }

    public Map<String, String> getReplaceBody() {
        return replaceBody;
    }
    public void setReplaceBody(Map<String, String> replaceBody) {
        this.replaceBody = replaceBody;
    }
}
