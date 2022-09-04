package com.mdonline.PrescriptionService.Exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PrescriptionNotFoundException.class)
    public final ResponseEntity<Object> handleAppointmentNotFoundExceptions(ObjectNotFoundException exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errors.toString(),
                ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public final ResponseEntity<Object> handleMethodNotAllowedException(MethodNotAllowedException exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "METHOD NOT ALLOWED",
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
