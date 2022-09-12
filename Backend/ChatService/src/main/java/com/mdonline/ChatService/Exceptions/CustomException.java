package com.mdonline.ChatService.Exceptions;

/*
    This class creates the custom exception.
 */

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errorMessage;
    private Exception errorCode;
    private HttpStatus errorStatus;

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Exception errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException() {

    }

    public CustomException(String errorMessage, HttpStatus errorStatus) {
        this.errorMessage = errorMessage;
        this.errorStatus = errorStatus;
    }

    public CustomException(String errorMessage, Exception errorCode, HttpStatus errorStatus) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorStatus = errorStatus;
    }



}