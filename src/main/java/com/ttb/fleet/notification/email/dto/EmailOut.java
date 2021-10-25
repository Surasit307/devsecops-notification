package com.ttb.fleet.notification.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class EmailOut implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("requested_id")
    private String requestedId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("requested_timestamp")
    private String requestedTimeStamp;

    public String getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(String requestedId) {
        this.requestedId = requestedId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedTimeStamp() {
        return requestedTimeStamp;
    }

    public void setRequestedTimeStamp(String requestedTimeStamp) {
        this.requestedTimeStamp = requestedTimeStamp;
    }
}
