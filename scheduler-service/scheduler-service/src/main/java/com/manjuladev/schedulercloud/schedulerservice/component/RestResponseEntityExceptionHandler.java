package com.manjuladev.schedulercloud.schedulerservice.component;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(CustomizedException.class)
//    protected ResponseEntity<Object> handleCustomizedException(RuntimeException ex, WebRequest request) throws Exception {
//        return handleException(ex, request);
//    }
//
//
//    //    IllegalArgumentException.class, IllegalStateException.class,
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleConflict(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific Manjula";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
}