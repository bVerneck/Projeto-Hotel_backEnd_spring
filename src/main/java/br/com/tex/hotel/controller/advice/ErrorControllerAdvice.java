package br.com.tex.hotel.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity errorNotFoundDelete() {
        return ResponseEntity.notFound().build();
    }
}
