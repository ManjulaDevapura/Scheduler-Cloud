package com.manjuladev.schedulercloud.schedulerservice.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Project from this code")  // 404
public class CustomizedException extends Exception {
    private final String code;
    private final String message;
    private final String value;

    public CustomizedException(String code, String message, String value) {
        super(message);
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getValue() {
        return value;
    }
}
