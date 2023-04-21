package br.com.tex.hotel.controller.advice;

import br.com.tex.hotel.model.dto.validCampos.OutputValidCamposDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorBadReques(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(new OutputValidCamposDTO().lista(ex.getFieldErrors()));
    }
}
