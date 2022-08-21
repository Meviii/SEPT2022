package com.project.mdonline.Exceptions;

/*
    This class creates the custom exception.
 */

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errorMessage;
    private String errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public EntityNotFoundException() {

    }

    public EntityNotFoundException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

}