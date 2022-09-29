package com.mdonline.ChatService.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
    This class controls custom exceptions
 */

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customException(CustomException exception) {
        return new ResponseEntity<>(exception.getErrorMessage(), exception.getErrorStatus());
    }

}