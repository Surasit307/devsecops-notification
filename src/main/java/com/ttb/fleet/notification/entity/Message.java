package com.ttb.fleet.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer messageId;
    private String language;
    private String subject;
    private String content;
    private String html_content;
    private Timestamp create_on;
    private String create_by;
    private Timestamp update_on;
    private String update_by;
    private String status;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
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

    public Timestamp getCreateOn() {
        return create_on;
    }

    public void setCreateOn(Timestamp create_on) {
        this.create_on = create_on;
    }

    public String getCreateBy() {
        return create_by;
    }

    public void setCreateBy(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getUpdateOn() {
        return update_on;
    }

    public void setUpdateOn(Timestamp update_on) {
        this.update_on = update_on;
    }

    public String getUpdateBy() {
        return update_by;
    }

    public void setUpdateBy(String create_by) {
        this.update_by = update_by;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
