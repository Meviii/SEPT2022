package com.mdonline.ChatService.Exceptions;

/*
    This class is designed to return two values from a service function.

    Example:
        - We want to add a new user and ask the service layer to perform the business logic. If the
        code fails, we return a false boolean with the exception, instead of a boolean or exception alone.

        Return: (didAdd = false, Exception = e)
 */

public class BoolAndExceptionReturner {
    private Boolean isSuccess;
    private Exception exception;

    public BoolAndExceptionReturner() {
    }

    public BoolAndExceptionReturner(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public BoolAndExceptionReturner(Boolean isSuccess, Exception exception) {
        this.isSuccess = isSuccess;
        this.exception = exception;
    }

    public Boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean success) {
        isSuccess = success;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "BoolAndExceptionReturner{" +
                "isSuccess=" + isSuccess +
                ", exception=" + exception +
                '}';
    }
}
