package com.ttb.fleet.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private String messageId;
    private String language;
    private String subject;
    private String content;
    private Timestamp create_on;
    private String create_by;
    private Timestamp update_on;
    private String update_by;
    private String status;
}
