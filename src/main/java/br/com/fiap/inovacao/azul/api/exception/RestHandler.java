package br.com.fiap.inovacao.azul.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> erro404(){
        return ResponseEntity.notFound().build();
    }

    /*
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<String> domainException(DomainException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
     */
}
