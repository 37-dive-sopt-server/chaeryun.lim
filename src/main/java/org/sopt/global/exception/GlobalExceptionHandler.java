package org.sopt.global.exception;

import org.sopt.global.api.ApiResponse;
import org.sopt.global.exception.handler.MemberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ApiResponse<Void>> handleMemberException(MemberException ex) {

        HttpStatus httpStatus = ex.getErrorCode().getHttpStatus();

        return ResponseEntity.status(httpStatus).body(
                ApiResponse.fail(
                        ex.getErrorCode().getHttpCode(),
                        ex.getMessage()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.fail(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "서버 내부 오류입니다."
                )
        );
    }
}
