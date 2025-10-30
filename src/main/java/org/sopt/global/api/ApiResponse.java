package org.sopt.global.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * API 표준 응답 포맷
 *
 * @param <T> 실제 응답 데이터 타입
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(int status, String message, T data) {

    /**
     *  일반적인 성공 응답 (HTTP 200)
     */
    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<T>(200, message, data);
    }

    /**
     *  리소스 생성 성공 응답 (HTTP 201)
     */
    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<T>(201, message, data);
    }

    /**
     *  실패 응답 (data 포함)
     */
    public static <T> ApiResponse<T> fail(int status, String message, T data) {
        return new ApiResponse<T>(status, message, data);
    }

    /**
     *  실패 응답 (data 미포함)
     */
    public static <T> ApiResponse<T> fail(int status, String message) {
        return new ApiResponse<T>(status, message, null);
    }
}
