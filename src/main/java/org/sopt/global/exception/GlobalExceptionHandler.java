package org.sopt.global.exception;

import org.sopt.global.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Valid 유효성 검사 실패 시 발생하는 예외를 처리
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = Objects.requireNonNull(ex.getBindingResult().getFieldError());
        String errorMessage = String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.fail(
                        HttpStatus.BAD_REQUEST.value(),
                        errorMessage
                )
        );
    }

    /**
     * HTTP Request Body의 형식이 잘못되었을 경우 발생하는 예외를 처리
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.fail(
                        HttpStatus.BAD_REQUEST.value(),
                        "요청 본문의 형식이 잘못되었습니다. (예: Enum 값 불일치)"
                )
        );
    }

    /**
     * 직접 정의한 비즈니스 예외를 처리
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleCustomException(CustomException ex) {
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(
                ApiResponse.fail(
                        ex.getErrorCode().getHttpCode(),
                        ex.getMessage()
                )
        );
    }

    /**
     * 위에서 처리하지 못한 모든 예외를 처리
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception ex) {
        // 로깅 필요: ex.printStackTrace() 또는 로깅 프레임워크 사용
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.fail(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "서버 내부 오류가 발생했습니다."
                )
        );
    }
}
