package com.ashwin.banking.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex){

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        Map<String, String> errorsMap = new HashMap<>();
        for(FieldError e : errors){
            errorsMap.put(e.getField(),e.getDefaultMessage());
        }

        ErrorResponse errorResponse = new
                ErrorResponse(LocalDateTime.now(),ex.getStatusCode().value(),"Validation failed",
                request.getRequestURI(),errorsMap);

        return ResponseEntity.badRequest()
                .body(errorResponse);
    }
}
