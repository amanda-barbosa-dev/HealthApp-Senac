package com.example.demo.shared;

import com.example.demo.model.ErrorTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<ErrorTemplate> handleRuntimeException(RuntimeException e){
        ErrorTemplate error;
        error = new ErrorTemplate();
        error.setErrorCode(500);
        error.setErrorMessage(e.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        error.setTraceId(String.valueOf(UUID.randomUUID()));
        return ResponseEntity.internalServerError().body(error);
    }
}
