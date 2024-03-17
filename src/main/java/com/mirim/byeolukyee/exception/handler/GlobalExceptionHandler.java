package com.mirim.byeolukyee.exception.handler;

import com.mirim.byeolukyee.exception.UserNotFoundException;
import com.mirim.byeolukyee.exception.error.ErrorCode;
import com.mirim.byeolukyee.exception.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ErrorCode errorCode;
    private HttpStatus httpStatus;

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(ErrorResponse.of(ErrorCode.USER_NOT_FOUND));
    }
}
