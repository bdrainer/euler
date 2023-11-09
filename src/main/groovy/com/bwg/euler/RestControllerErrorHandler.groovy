package com.bwg.euler


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestControllerErrorHandler {

    @ExceptionHandler(com.bwg.euler.exception.BadRequestException.class)
    ResponseEntity<?> badRequet(com.bwg.euler.exception.BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.message)
    }
}
