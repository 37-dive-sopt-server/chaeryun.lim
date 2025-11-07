package org.sopt.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
    EXIST_EMAIL(HttpStatus.BAD_REQUEST,400, "중복된 이메일입니다."),
    NOT_VALID_BIRTHDAY(HttpStatus.BAD_REQUEST, 400, "생일은 yyyy-MM-dd 형식이어야 합니다."),
    NOT_VALID_EMAIL(HttpStatus.BAD_REQUEST, 400, "이메일 형식이 올바르지 않습니다."),
    EMPTY_NAME(HttpStatus.BAD_REQUEST, 400, "이름은 비어 있을 수 없습니다."),
    EMPTY_BIRTHDAY(HttpStatus.BAD_REQUEST, 400, "생일은 비어 있을 수 없습니다."),
    EMPTY_GENDER(HttpStatus.BAD_REQUEST, 400, "성별은 비어 있을 수 없습니다."),
    EMPTY_DATA(HttpStatus.BAD_REQUEST, 400, "요청 데이터가 비어 있습니다."),
    AGE_RESTRICTION(HttpStatus.BAD_REQUEST, 400, "20세 미만의 회원은 가입이 불가능합니다."),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, 404, "⚠️ 해당 ID의 회원을 찾을 수 없습니다."),
    NOT_FOUND_ARTICLE(HttpStatus.NOT_FOUND, 404, "⚠️ 해당 ID의 아티클을 찾을 수 없습니다."),
    MEMBER_FILE_LOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "회원 파일 로드에 오류가 발생했습니다."),
    MEMBER_FILE_SAVE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "회원 파일 저장에 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final int httpCode;
    private final String msg;

    ErrorCode(HttpStatus httpStatus, int httpCode, String msg) {
        this.httpStatus = httpStatus;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public int getHttpCode() {
        return httpCode;
    }

    public String getMsg() {
        return msg;
    }
}
