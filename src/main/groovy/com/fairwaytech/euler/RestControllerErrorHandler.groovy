package com.fairwaytech.euler

import com.fairwaytech.euler.exception.BadRequestException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestControllerErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<?> badRequet(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.message)
    }
}
