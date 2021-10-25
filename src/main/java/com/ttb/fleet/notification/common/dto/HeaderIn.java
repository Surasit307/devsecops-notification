package com.ttb.fleet.notification.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class HeaderIn implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("x-requested-id")
    private String requestedId;
    @JsonProperty("x-requested-timestamp")
    private String requestedTimeStamp;
    @JsonProperty("authorization")
    private String authorization;
    @JsonProperty("x-token")
    private String token;
    @JsonProperty("x-authorizer")
    private String authorizer;
    @JsonProperty("x-journey")
    private String journey;
    @JsonProperty("x-api-key")
    private String apiKey;

    public String getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(String requestedId) {
        this.requestedId = requestedId;
    }

    public String getRequestedTimeStamp() {
        return requestedTimeStamp;
    }

    public void setRequestedTimeStamp(String requestedTimeStamp) {
        this.requestedTimeStamp = requestedTimeStamp;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
