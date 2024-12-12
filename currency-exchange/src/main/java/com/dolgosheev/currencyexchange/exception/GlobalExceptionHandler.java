package com.dolgosheev.currencyexchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCurrencyNotFound(CurrencyNotFoundException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CurrencyAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCurrencyAlreadyExists(CurrencyAlreadyExistsException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExchangeRateNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleExchangeRateNotFound(ExchangeRateNotFoundException ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception ex) {
        return new ResponseEntity<>(Map.of("message", "Внутренняя ошибка сервера"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}