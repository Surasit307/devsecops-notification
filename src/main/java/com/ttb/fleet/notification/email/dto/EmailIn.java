package com.ttb.fleet.notification.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class EmailIn  implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("to")
    private String[] to;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("content")
    private String content;

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
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
}
