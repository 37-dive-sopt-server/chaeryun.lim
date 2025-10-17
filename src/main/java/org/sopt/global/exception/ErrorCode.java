package org.sopt.global.exception;

public enum ErrorCode {
    EXIST_EMAIL(400, "중복된 이메일입니다."),
    NOT_VALID_BIRTHDAY(400, "생일은 yyyy-MM-dd 형식이어야 합니다."),
    NOT_VALID_EMAIL(400, "이메일 형식이 올바르지 않습니다."),
    EMPTY_NAME(400, "이름은 비어 있을 수 없습니다."),
    EMPTY_BIRTHDAY(400, "생일은 비어 있을 수 없습니다."),
    EMPTY_GENDER(400, "성별은 비어 있을 수 없습니다."),
    EMPTY_DATA(400, "요청 데이터가 비어 있습니다."),
    AGE_RESTRICTION(400, "20세 미만의 회원은 가입이 불가능합니다."),
    NOT_FOUND_MEMBER(404, "⚠️ 해당 ID의 회원을 찾을 수 없습니다."),
    MEMBER_FILE_LOAD_ERROR(500, "회원 파일 로드에 오류가 발생했습니다."),
    MEMBER_FILE_SAVE_ERROR(500, "회원 파일 저장에 오류가 발생했습니다.");

    private final int httpCode;
    private final String msg;

    ErrorCode(int httpCode, String msg) {
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getMsg() {
        return msg;
    }
}
