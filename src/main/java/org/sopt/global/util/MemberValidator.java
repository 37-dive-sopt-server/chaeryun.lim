package org.sopt.global.util;

import org.sopt.domain.member.dto.request.member.CreateMemberRequest;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.MemberException;

import java.time.format.DateTimeParseException;

// 회원 관련 입력 검증
public class MemberValidator {

    // 회원 생성 검증
    public static void validate(CreateMemberRequest request){
        if (request == null) {
            throw new MemberException(ErrorCode.EMPTY_DATA);
        }

        // 이름 검증
        if (request.name() == null || request.name().isBlank()) {
            throw new MemberException(ErrorCode.EMPTY_NAME);
        }

        // 이메일 검증
        if (request.email() == null || !request.email().contains("@")) {
            throw new MemberException(ErrorCode.NOT_VALID_EMAIL);
        }

        // 생일 검증
        if (request.birthDay() == null || request.birthDay().isBlank()) {
            throw new MemberException(ErrorCode.EMPTY_BIRTHDAY);
        }

        try {
            DateUtil.string2Date(request.birthDay());
        } catch (DateTimeParseException e) {
            throw new MemberException(ErrorCode.NOT_VALID_BIRTHDAY);
        }

        // 성별 검증
        if (request.gender() == null || request.gender().isBlank()) {
            throw new MemberException(ErrorCode.EMPTY_GENDER);
        }
    }
}
