package com.trendyol.kodluyoruz.playlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException exception) {
        ExceptionDetail detail = ExceptionDetail.builder()
                .description("Resource Not Found")
                .message(exception.getMessage())
                .date(new Date()).build();

        return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> internalServerErrorException(InternalServerErrorException exception) {
        ExceptionDetail detail = ExceptionDetail.builder()
                .description("Internal Server Error")
                .message(exception.getMessage())
                .date(new Date()).build();

        return new ResponseEntity<>(detail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
