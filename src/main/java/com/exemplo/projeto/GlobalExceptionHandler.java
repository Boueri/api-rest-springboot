package com.exemplo.projeto.controller.exception;

import com.exemplo.projeto.service.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> entidadeNaoEncontrada(ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", Instant.now().toString());
        erro.put("status", HttpStatus.NOT_FOUND.value());
        erro.put("error", "Recurso não encontrado");
        erro.put("message", e.getMessage());
        erro.put("path", request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}