package com.example.demo.model;

import java.time.LocalDateTime;

public class ErrorTemplate {

    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime timeStamp;

    private String traceId;

    public ErrorTemplate(Integer errorCode, String errorMessage, LocalDateTime timeStamp, String traceId) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
        this.traceId = traceId;
    }

    public ErrorTemplate() {

    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
