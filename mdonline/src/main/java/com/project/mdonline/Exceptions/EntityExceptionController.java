package com.project.mdonline.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
    This class controls our custom exceptions for an entity
 */

@ControllerAdvice
public class EntityExceptionController {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<String> notFound(EntityNotFoundException exception) {
            return new ResponseEntity<String>(exception.getErrorMessage(), HttpStatus.NOT_FOUND);
        }
}